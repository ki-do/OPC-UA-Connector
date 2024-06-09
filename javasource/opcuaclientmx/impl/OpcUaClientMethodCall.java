package opcuaclientmx.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.UIDefaults;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.nodes.UaMethodNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;
import org.eclipse.milo.opcua.stack.core.types.structured.CallMethodRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CallMethodResult;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;

import opcuaclientmx.proxies.OpcUaServerCfg;

public class OpcUaClientMethodCall {

	private static final ILogNode logger = Core.getLogger("OpcUA");

	public static String callMethod(String inputArgs, OpcUaServerCfg OpcUaServerCfg, IContext context,
			String objectNodeId, String methodNodeId) throws CoreException {
		OpcUaClient client = OpcUaClientManager.retrieve(context, OpcUaServerCfg);

		if (objectNodeId == null || "".equals(objectNodeId))
			throw new CoreException("[MethodCall] Please provide a NodeId of an object node.");
		NodeId objectNode = NodeId.parse(objectNodeId);

		if (methodNodeId == null || "".equals(methodNodeId))
			throw new CoreException("[MethodCall] Please provide a NodeId of a method node.");
		NodeId methodNode = NodeId.parse(methodNodeId);

		try {
			logger.trace(String.format("[MethodCall] Calling a method at [Server:%s|NodeId:%s]",
					OpcUaServerCfg.getServerID(), methodNodeId));

			Variant[] inputs = getVariantsByCachedDataType(client, methodNode, inputArgs, context);
			Arrays.asList(inputs).forEach(i -> logger.info(
					String.format("[MethodCall] [resultOfgetVariants] %s, %s", i, i.getDataType().get().toString())));
			CallMethodResult result = client.call(new CallMethodRequest(objectNode, methodNode, inputs)).get();

			if (result.getOutputArguments() != null) {
				if (result.getOutputArguments().length != 0) {
					logger.info(String.format("[MethodCall] Result: %s", result.getOutputArguments()[0].toString()));
					return result.getOutputArguments()[0].toString();
				} else {
					return null;
				}
			} else {
				return null;
			}

		} catch (NumberFormatException | InterruptedException | ExecutionException e) {
			logger.error(e);
		}

		return null;
	}

	private static Variant[] getVariantsByCachedDataType(OpcUaClient client, NodeId methodNode, String inputArgs,
			IContext context) throws InterruptedException, ExecutionException, CoreException {

		UaMethodNode uaMethodNode = (UaMethodNode) client.getAddressSpace().getNodeInstance(methodNode).get();
		List<Argument> args = new ArrayList<Argument>();
		try {
			args = Arrays.asList(uaMethodNode.getInputArguments().get());
			args.forEach(arg -> logger.info(String.format("[MethodCall] Argument: %s", arg.toString())));
		} catch (Exception e) {
			logger.info(e);
			// throw new CoreException("[MethodCall] No input arguments.");
		}
		List<String> values = new ArrayList<>();

		StringBuilder currentValue = new StringBuilder();
		boolean inArray = false;
		int depth = 0;

		for (int i = 0; i < inputArgs.length(); i++) {
			char c = inputArgs.charAt(i);

			if (c == '[') {
				currentValue = new StringBuilder();
				inArray = true;
				depth++;
			} else if (c == ']') {
				depth--;
				if (depth == 0) {
					inArray = false;
					values.add(currentValue.toString());
					currentValue = new StringBuilder();
				}
			} else if (c == ',' && !inArray && currentValue.length() > 0) {
				values.add(currentValue.toString());
				currentValue = new StringBuilder();
			} else {
				if (c != '{' && c != '}')
				currentValue.append(c);
			}
		}

		if (currentValue.length() > 0) {
			values.add(currentValue.toString());
		}
		if (values.size() == 1 && values.get(0).isEmpty()) {
			//values = new String[0];
		}

		Variant[] variants = new Variant[args.size()];

		if (values.size() != args.size()) {
			throw new CoreException(
					"[MethodCall] Number of input arguments " + values.size() + " does not match the number of arguments in the method signature " + args.size());
		} else {
			for (int i = 0; i < args.size(); i++) {

				Object identifier = args.get(i).getDataType().getIdentifier();
				Integer valueRank = args.get(i).getValueRank();
				UInteger id = UInteger.valueOf(0);
				if (identifier instanceof UInteger) {
					id = (UInteger) identifier;
				}
				if (valueRank == -1) { // Scalar value

					switch (id.intValue()) {
						case 1: // Boolean(1, Boolean.class),
							variants[i] = new Variant(Boolean.valueOf(values.get(i)));
							break;
						case 4: // Int16(4, Short.class),
							variants[i] = new Variant(Short.valueOf(values.get(i)));
							break;
						case 5: // UInt16(5, UShort.class),
							variants[i] = new Variant(Unsigned.ushort(values.get(i)));
							break;
						case 6: // Int32(6, Integer.class),
							variants[i] = new Variant(Integer.valueOf(values.get(i)));
							break;
						case 7: // UInt32(7, UInteger.class),
							variants[i] = new Variant(UInteger.valueOf(values.get(i)));
							break;
						case 8: // Int64(8, Long.class),
							variants[i] = new Variant(Long.valueOf(values.get(i)));
							break;
						case 10: // Float(10, Float.class),
						case 11: // Double(11, Double.class),
							variants[i] = new Variant(Double.valueOf(values.get(i)));
							break;
						case 12: // String(12, String.class),
							variants[i] = new Variant(values.get(i));
							break;
						default:
							throw new CoreException(
									"[MethodCall] Data Type " + id.intValue()
											+ " isn't implemented yet.");
					}
				}
				if (valueRank == 1) { // array
					UInteger arraySize = args.get(i).getArrayDimensions()[0];
					switch (id.intValue()) {
						case 1: // Boolean(1, Boolean.class),
							Boolean[] fixedbvalues = new Boolean[arraySize.intValue()];
							String[] arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedbvalues[j] = Boolean.parseBoolean(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixedbvalues);
							break;
						case 4: // Int16(4, Short.class),
							Short[] fixedsvalues = new Short[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedsvalues[j] = Short.parseShort(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixedsvalues);
							break;
						case 5: // UInt16(5, UShort.class),
							UShort[] fixedusvalues = new UShort[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedusvalues[j] = Unsigned.ushort(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixedusvalues);
							break;
						case 6: // Int32(6, Integer.class),
							Integer[] fixedivalues = new Integer[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedivalues[j] = Integer.parseInt(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixedivalues);
							break;
						case 7: // UInt32(7, UInteger.class),
							UInteger[] fixeduivalues = new UInteger[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixeduivalues[j] = UInteger.valueOf(Integer.parseUnsignedInt(arrayValues[j].trim()));
							}
							variants[i] = new Variant(fixeduivalues);
							break;
						case 8: // Int64(8, Long.class),
							Long[] fixedlvalues = new Long[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedlvalues[j] = Long.parseLong(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixedlvalues);
							break;
						case 10: // Float(10, Float.class),
						case 11: // Double(11, Double.class),
							Double[] fixeddvalues = new Double[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixeddvalues[j] = Double.parseDouble(arrayValues[j].trim());
							}
							variants[i] = new Variant(fixeddvalues);
							break;
						case 12: // String(12, String.class),
							String[] fixedstrvalues = new String[arraySize.intValue()];
							arrayValues = getArrayvaluesFromArrayParam(values.get(i));
							for (int j = 0; j < arraySize.intValue(); j++) {
								fixedstrvalues[j] = arrayValues[j].trim();
							}
							variants[i] = new Variant(fixedstrvalues);
							break;
						default:
							throw new CoreException(
									"[MethodCall] Data Type " + id.intValue()
											+ " isn't implemented yet.");
					}
				}
			}
		}

		return variants;
	}

	private static String[] getArrayvaluesFromArrayParam(String arrayParam) {
		return arrayParam.split(",");
	}
}
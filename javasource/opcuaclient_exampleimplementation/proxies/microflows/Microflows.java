// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package opcuaclient_exampleimplementation.proxies.microflows;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public final class Microflows
{
	/**
	 * Private constructor to prevent instantiation of this class. 
	 */
	private Microflows() {}

	// These are the microflows for the OpcUaClient_ExampleImplementation module
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder dS_GetGateBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.DS_GetGate");
		return builder;
	}

	public static java.util.List<opcuaclient_exampleimplementation.proxies.GatePLC> dS_GetGate(IContext context)
	{
		Object result = dS_GetGateBuilder().execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> opcuaclient_exampleimplementation.proxies.GatePLC.initialize(context, obj));
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder getOpcUaNodeSetBuilder(
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.GetOpcUaNodeSet");
		builder = builder.withParam("OpcUaServerCfg", _opcUaServerCfg);
		return builder;
	}

	public static opcuaclient_exampleimplementation.proxies.Set getOpcUaNodeSet(
		IContext context,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		Object result = getOpcUaNodeSetBuilder(
				_opcUaServerCfg
			)
			.execute(context);
		return result == null ? null : opcuaclient_exampleimplementation.proxies.Set.initialize(context, (IMendixObject) result);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder getSetBuilder(
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.GetSet");
		builder = builder.withParam("OpcUaServerCfg", _opcUaServerCfg);
		return builder;
	}

	public static opcuaclient_exampleimplementation.proxies.Set getSet(
		IContext context,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		Object result = getSetBuilder(
				_opcUaServerCfg
			)
			.execute(context);
		return result == null ? null : opcuaclient_exampleimplementation.proxies.Set.initialize(context, (IMendixObject) result);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder mB_CloseGateBuilder(
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MB_CloseGate");
		builder = builder.withParam("GatePLC", _gatePLC);
		return builder;
	}

	public static void mB_CloseGate(
		IContext context,
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		mB_CloseGateBuilder(
				_gatePLC
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder mB_OpenGateBuilder(
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MB_OpenGate");
		builder = builder.withParam("GatePLC", _gatePLC);
		return builder;
	}

	public static void mB_OpenGate(
		IContext context,
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		mB_OpenGateBuilder(
				_gatePLC
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder mB_ResetSubscriptionsBuilder(
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MB_ResetSubscriptions");
		builder = builder.withParam("GatePLC", _gatePLC);
		return builder;
	}

	public static void mB_ResetSubscriptions(
		IContext context,
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		mB_ResetSubscriptionsBuilder(
				_gatePLC
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder mB_SetupSubscriptionsBuilder(
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MB_SetupSubscriptions");
		builder = builder.withParam("GatePLC", _gatePLC);
		return builder;
	}

	public static void mB_SetupSubscriptions(
		IContext context,
		opcuaclient_exampleimplementation.proxies.GatePLC _gatePLC
	)
	{
		mB_SetupSubscriptionsBuilder(
				_gatePLC
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder monitoredItem_CreateBuilder(
		java.lang.String _payload,
		java.lang.String _subscriptionID
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MonitoredItem_Create");
		builder = builder.withParam("Payload", _payload);
		builder = builder.withParam("SubscriptionID", _subscriptionID);
		return builder;
	}

	public static void monitoredItem_Create(
		IContext context,
		java.lang.String _payload,
		java.lang.String _subscriptionID
	)
	{
		monitoredItem_CreateBuilder(
				_payload,
				_subscriptionID
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder monitoredItem_DeleteBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.MonitoredItem_Delete");
		return builder;
	}

	public static void monitoredItem_Delete(IContext context)
	{
		monitoredItem_DeleteBuilder().execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder nav_OpenDashboardBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.Nav_OpenDashboard");
		return builder;
	}

	public static void nav_OpenDashboard(IContext context)
	{
		nav_OpenDashboardBuilder().execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_Browse_FromNodeBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Browse_FromNode");
		builder = builder.withParam("OpcUaNode", _opcUaNode);
		return builder;
	}

	public static java.util.List<opcuaclient_exampleimplementation.proxies.OpcUaNode> opcUaNode_Browse_FromNode(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		Object result = opcUaNode_Browse_FromNodeBuilder(
				_opcUaNode
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> opcuaclient_exampleimplementation.proxies.OpcUaNode.initialize(context, obj));
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_Browse_FromSetBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Browse_FromSet");
		builder = builder.withParam("OpcUaNode", _opcUaNode);
		return builder;
	}

	public static java.util.List<opcuaclient_exampleimplementation.proxies.OpcUaNode> opcUaNode_Browse_FromSet(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		Object result = opcUaNode_Browse_FromSetBuilder(
				_opcUaNode
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> opcuaclient_exampleimplementation.proxies.OpcUaNode.initialize(context, obj));
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_Browse_TopLevelBuilder(
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServer
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Browse_TopLevel");
		builder = builder.withParam("OpcUaServer", _opcUaServer);
		return builder;
	}

	public static void opcUaNode_Browse_TopLevel(
		IContext context,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServer
	)
	{
		opcUaNode_Browse_TopLevelBuilder(
				_opcUaServer
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_CreateBuilder()
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Create");
		return builder;
	}

	public static opcuaclient_exampleimplementation.proxies.OpcUaNode opcUaNode_Create(IContext context)
	{
		Object result = opcUaNode_CreateBuilder().execute(context);
		return result == null ? null : opcuaclient_exampleimplementation.proxies.OpcUaNode.initialize(context, (IMendixObject) result);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_DeleteAllBuilder(
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_DeleteAll");
		builder = builder.withParam("OpcUaServerCfg", _opcUaServerCfg);
		return builder;
	}

	public static void opcUaNode_DeleteAll(
		IContext context,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		opcUaNode_DeleteAllBuilder(
				_opcUaServerCfg
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_GetForNodeViewBuilder(
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_GetForNodeView");
		builder = builder.withParam("OpcUaServerCfg", _opcUaServerCfg);
		return builder;
	}

	public static java.util.List<opcuaclient_exampleimplementation.proxies.OpcUaNode> opcUaNode_GetForNodeView(
		IContext context,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		Object result = opcUaNode_GetForNodeViewBuilder(
				_opcUaServerCfg
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> opcuaclient_exampleimplementation.proxies.OpcUaNode.initialize(context, obj));
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_ReadBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Read");
		builder = builder.withParam("OpcUaNode", _opcUaNode);
		return builder;
	}

	public static void opcUaNode_Read(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		opcUaNode_ReadBuilder(
				_opcUaNode
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_SubscribeBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Subscribe");
		builder = builder.withParam("OpcUaNode", _opcUaNode);
		return builder;
	}

	public static void opcUaNode_Subscribe(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		opcUaNode_SubscribeBuilder(
				_opcUaNode
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder opcUaNode_WriteBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.OpcUaNode_Write");
		builder = builder.withParam("OpcUaNode", _opcUaNode);
		return builder;
	}

	public static void opcUaNode_Write(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _opcUaNode
	)
	{
		opcUaNode_WriteBuilder(
				_opcUaNode
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder processOpcUaNodeBuilder(
		opcuaclient_exampleimplementation.proxies.OpcUaNode _mappingParent,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _parentOpcUaNode,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.ProcessOpcUaNode");
		builder = builder.withParam("MappingParent", _mappingParent);
		builder = builder.withParam("ParentOpcUaNode", _parentOpcUaNode);
		builder = builder.withParam("OpcUaServerCfg", _opcUaServerCfg);
		return builder;
	}

	public static void processOpcUaNode(
		IContext context,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _mappingParent,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _parentOpcUaNode,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServerCfg
	)
	{
		processOpcUaNodeBuilder(
				_mappingParent,
				_parentOpcUaNode,
				_opcUaServerCfg
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder processOpcUaNodeListBuilder(
		java.lang.String _result,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _parentOpcUaNode,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServer
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.ProcessOpcUaNodeList");
		builder = builder.withParam("Result", _result);
		builder = builder.withParam("ParentOpcUaNode", _parentOpcUaNode);
		builder = builder.withParam("OpcUaServer", _opcUaServer);
		return builder;
	}

	public static java.util.List<opcuaclient_exampleimplementation.proxies.OpcUaNode> processOpcUaNodeList(
		IContext context,
		java.lang.String _result,
		opcuaclient_exampleimplementation.proxies.OpcUaNode _parentOpcUaNode,
		opcuaclientmx.proxies.OpcUaServerCfg _opcUaServer
	)
	{
		Object result = processOpcUaNodeListBuilder(
				_result,
				_parentOpcUaNode,
				_opcUaServer
			)
			.execute(context);
		return result == null ? null : com.mendix.utils.ListUtils.map((java.util.List<IMendixObject>) result, obj -> opcuaclient_exampleimplementation.proxies.OpcUaNode.initialize(context, obj));
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder uA_ProcessEvent_GateDownBuilder(
		opcuaclientmx.proxies.Message _message
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.UA_ProcessEvent_GateDown");
		builder = builder.withParam("Message", _message);
		return builder;
	}

	public static void uA_ProcessEvent_GateDown(
		IContext context,
		opcuaclientmx.proxies.Message _message
	)
	{
		uA_ProcessEvent_GateDownBuilder(
				_message
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder uA_ProcessEvent_GateMovingBuilder(
		opcuaclientmx.proxies.Message _message
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.UA_ProcessEvent_GateMoving");
		builder = builder.withParam("Message", _message);
		return builder;
	}

	public static void uA_ProcessEvent_GateMoving(
		IContext context,
		opcuaclientmx.proxies.Message _message
	)
	{
		uA_ProcessEvent_GateMovingBuilder(
				_message
			)
			.execute(context);
	}
	public static com.mendix.core.actionmanagement.MicroflowCallBuilder uA_ProcessEvent_GateUpBuilder(
		opcuaclientmx.proxies.Message _message
	)
	{
		com.mendix.core.actionmanagement.MicroflowCallBuilder builder = Core.microflowCall("OpcUaClient_ExampleImplementation.UA_ProcessEvent_GateUp");
		builder = builder.withParam("Message", _message);
		return builder;
	}

	public static void uA_ProcessEvent_GateUp(
		IContext context,
		opcuaclientmx.proxies.Message _message
	)
	{
		uA_ProcessEvent_GateUpBuilder(
				_message
			)
			.execute(context);
	}
}

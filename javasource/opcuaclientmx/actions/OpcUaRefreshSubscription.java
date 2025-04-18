// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package opcuaclientmx.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import opcuaclientmx.impl.SubscriptionManager;
import opcuaclientmx.proxies.Subscription;

public class OpcUaRefreshSubscription extends CustomJavaAction<java.lang.Void>
{
	/** @deprecated use OpcUaServerCfg.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __OpcUaServerCfg;
	private final opcuaclientmx.proxies.OpcUaServerCfg OpcUaServerCfg;
	/** @deprecated use MonitoredItemObject.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __MonitoredItemObject;
	private final opcuaclientmx.proxies.MonitoredItem MonitoredItemObject;

	public OpcUaRefreshSubscription(
		IContext context,
		IMendixObject _opcUaServerCfg,
		IMendixObject _monitoredItemObject
	)
	{
		super(context);
		this.__OpcUaServerCfg = _opcUaServerCfg;
		this.OpcUaServerCfg = _opcUaServerCfg == null ? null : opcuaclientmx.proxies.OpcUaServerCfg.initialize(getContext(), _opcUaServerCfg);
		this.__MonitoredItemObject = _monitoredItemObject;
		this.MonitoredItemObject = _monitoredItemObject == null ? null : opcuaclientmx.proxies.MonitoredItem.initialize(getContext(), _monitoredItemObject);
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		
		Subscription SubscriptionObject = this.MonitoredItemObject.getMonitoredItem_Subscription();
		
		SubscriptionManager._getInstance().refreshSubscription(context(), this.OpcUaServerCfg, SubscriptionObject, this.MonitoredItemObject);
		
		return null;
	
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "OpcUaRefreshSubscription";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

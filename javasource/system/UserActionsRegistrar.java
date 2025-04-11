package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.registerUserAction(encryption.actions.DecryptString.class);
    registrator.registerUserAction(encryption.actions.EncryptString.class);
    registrator.registerUserAction(encryption.actions.GeneratePGPKeyRing.class);
    registrator.registerUserAction(encryption.actions.PGPDecryptDocument.class);
    registrator.registerUserAction(encryption.actions.PGPEncryptDocument.class);
    registrator.registerUserAction(encryption.actions.ValidatePrivateKeyRing.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaBrowse.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaBuildNodeId.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaConnectionTest.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaGetNodeDisplayName.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaMethod.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaRead.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaRefreshSubscription.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaSubscribe.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaUnsubscribe.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaUpdateCachedServerSettings.class);
    registrator.registerUserAction(opcuaclientmx.actions.OpcUaWrite.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}

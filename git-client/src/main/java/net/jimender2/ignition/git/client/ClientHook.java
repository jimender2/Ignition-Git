package net.jimender2.ignition.git.client;

import com.inductiveautomation.ignition.client.model.ClientContext;
import com.inductiveautomation.ignition.common.licensing.LicenseMode;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunctionDocProvider;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.vision.api.client.AbstractClientModuleHook;
import com.inductiveautomation.ignition.client.model.ClientContext;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.vision.api.client.AbstractClientModuleHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHook extends AbstractClientModuleHook {

	// private final Logger logger = LoggerFactory.getLogger(getClass());

	// @Override
	// public void startup(ClientContext context, LicenseState activationState)
	// throws Exception {
	// super.startup(context, activationState);
	// }

	// @Override
	// public void shutdown() {
	// super.shutdown();
	// }

	@Override
	public void initializeScriptManager(final ScriptManager manager) {
		super.initializeScriptManager(manager);
		manager.addScriptModule("system.jimender2.git", (Object) new ClientScriptModule(),
				(ScriptFunctionDocProvider) new PropertiesFileDocProvider());
	}

	@Override
	public void shutdown() {
		super.shutdown();
	}

	@Override
	public void notifyActivationStateChanged(final LicenseState licenseState) {
		super.notifyActivationStateChanged(licenseState);
	}

	@Override
	public void startup(final ClientContext context, final LicenseState activationState) throws Exception {
		super.startup(context, activationState);
	}

}

package net.jimender2.ignition.git.client;

import com.inductiveautomation.ignition.client.model.ClientContext;
import com.inductiveautomation.ignition.common.licensing.LicenseMode;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunctionDocProvider;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.vision.api.client.AbstractClientModuleHook;
import com.inductiveautomation.*;

public class ScriptingClientHook extends AbstractClientModuleHook
{
	@Override
	public void initializeScriptManager(final ScriptManager manager) {
		super.initializeScriptManager(manager);
		manager.addScriptModule("system.jimender2.net.git", (Object)new ClientScriptModule(), (ScriptFunctionDocProvider)new PropertiesFileDocProvider());
	}
	
	@Override
	public void shutdown() {
		super.shutdown();
	}
	
}
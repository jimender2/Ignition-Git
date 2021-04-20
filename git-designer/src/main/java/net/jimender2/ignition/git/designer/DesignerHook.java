package net.jimender2.ignition.git.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseMode;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import net.jimender2.ignition.git.client.ClientScriptModule;
import net.jimender2.ignition.git.gateway.GatewayScriptModule;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.inductiveautomation.ignition.common.licensing.LicenseMode;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;


public class DesignerHook extends AbstractDesignerModuleHook {

    private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void initializeScriptManager(ScriptManager manager) {
		super.initializeScriptManager(manager);

		manager.addScriptModule(
			"system.jimender2.git",
			new GatewayScriptModule(),
			new PropertiesFileDocProvider()
		);
	}

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        super.startup(context, activationState);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

}

package net.jimender2.ignition.git.client;

import com.inductiveautomation.ignition.client.gateway_interface.ModuleRPCFactory;
import net.jimender2.ignition.git.common.Scripts;
import net.jimender2.ignition.git.common.AbstractScriptModule;

public class ClientScriptModule extends AbstractScriptModule
{
    private final Scripts rpc;
	
    public ClientScriptModule() {
        this.rpc = (Scripts)ModuleRPCFactory.create(
            "net.jimender2.ignition.git.scripting-function",
            (Class)Scripts.class
        );
    }

    @Override
    protected int addrpc(String path) {
        return this.rpc.add(path);
    }
}
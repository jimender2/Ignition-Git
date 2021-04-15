mvn clean install
java -jar "module-signer-1.0.0-SNAPSHOT-jar-with-dependencies.jar" -keystore="keystore" -keystore-pwd="8675309" -alias="net.jimender2.ignition.git" -alias-pwd="8675309" -chain="net.jimender2.ignition.git.p7b" -module-in="git-build/target/git-Ignition-Module-unsigned.modl" -module-out="/mnt/c/Users/admin/Desktop/gitmodule.modl"

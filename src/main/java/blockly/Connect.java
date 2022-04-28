package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Connect {

public static final int TIMEOUT = 300;

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Connect
public static Var conexaoBanco(@ParamMetaData(description = "usuarioLogado") Var usuarioLogado) throws Exception {
 return new Callable<Var>() {

   private Var conexao = Var.VAR_NULL;

   public Var call() throws Exception {

    conexao =
    cronapi.database.Operations.configureConnection(
    Var.valueOf("com.mysql.jdbc.Driver"),
    Var.valueOf("jdbc:mysql://rds-oncronos-shared.cx8gelec2ybx.us-east-1.rds.amazonaws.com:3306/IBase64?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC&useSSL=false"),
    Var.valueOf("usr_db_doc"),
    Var.valueOf("rjfe2Vm9yQWg3R8Y"));

    if (
    Var.valueOf(!usuarioLogado.equals(
    Var.valueOf("admin"))).getObjectAsBoolean()) {

        conexao =
        cronapi.database.Operations.configureConnection(
        Var.valueOf("com.mysql.jdbc.Driver"),
        Var.valueOf("jdbc:mysql://db-conexao2.cfdacj6pdovg.us-east-1.rds.amazonaws.com:3306/db_conexao2?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC&useSSL=false"),
        Var.valueOf("root"),
        Var.valueOf("pbd7fcc2319cf43b589946575001db"));
    }
    return conexao;
   }
 }.call();
}

}


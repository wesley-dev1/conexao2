package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Bloco {

public static final int TIMEOUT = 300;

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Bloco
public static Var ConexaoBanco(@ParamMetaData(description = "usuarioLogado") Var usuarioLogado) throws Exception {
 return new Callable<Var>() {

   private Var conexao = Var.VAR_NULL;

   public Var call() throws Exception {

    if (
    Var.VAR_TRUE.getObjectAsBoolean()) {

        conexao =
        cronapi.database.Operations.configureConnection(
        Var.valueOf("com.mysql.jdbc.Driver"),
        Var.valueOf("jdbc:mysql://rds-oncronos-shared.cx8gelec2ybx.us-east-1.rds.amazonaws.com:3306/doc?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC&useSSL=false"),
        Var.valueOf("usr_db_doc"),
        Var.valueOf("rjfe2Vm9yQWg3R8Y"));
    } else {

        conexao =
        cronapi.database.Operations.configureConnection(
        Var.valueOf("com.mysql.jdbc.Driver"),
        Var.valueOf("jdbc:mysql://rds-oncronos-shared.cx8gelec2ybx.us-east-1.rds.amazonaws.com:3306/IBase64?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC&useSSL=false"),
        Var.valueOf("usr_db_doc"),
        Var.valueOf("rjfe2Vm9yQWg3R8Y"));
    }
    return conexao;
   }
 }.call();
}

}


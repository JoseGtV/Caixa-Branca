package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    //1

    /**
     *
     * @return retorna a conexão com o bando de dados SQL
     * Recomendação: Utilizar a classe usuario para realizar a conexão com banco de dados não é ideal
     * Criar uma nova classe (Ex: UserDAO) para realizar a conexão.
     */
    public Connection conectarBD() {
        Connection conn = null;
        //2
        try {
            /**
             * NewInstance utilizado de forma incorreta
             * Correção:
             * String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
             * conn = DriverManager.getConnection(url);
             */
            //3
                Class.forName("com.mysql.Driver.Manager").newInstance();
                String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
                conn = DriverManager.getConnection(url);
            }
        /**
         * Bloco Catch vazio, sem tratativas para exceções.
         * Recomendação: Realizar um Log informando erro capturado pelo catch
         * } catch (Exception e) {
         *     // Lidar com exceções
         *     System.out.println("Exceção capturada!");
         * }
         */
        //4
            catch (Exception e) {}
        //5
        /**
         *Retorna a conexão com o  banco de dados
         */
        return conn;
    }
    public String nome = "";
    public boolean result = false;
    //6

    /**
     *
     * @param login , possui como parametro a String Login
     * @param senha , possui como parametro a String Senha
     * @return  retorna o usuario de acordo com o Login e a senha
     */
    public boolean verificarUsuario(String login, String senha) {

        String sql = "";
        //7
        Connection conn = conectarBD();
        //INTRODUÇÃO SQL
        sql += "select nome from usuarios";
        sql += "where login = " + "'" + login + "'";
        sql += "and senha = " + "'" + senha + "'";
        //8
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                //9
                if (rs.next()) {
                //10
                result = true;
                nome = rs.getString("nome");
                }
            /**
             * Bloco Catch vazio, sem tratativas para exceções.
             * Recomendação: Realizar um Log informando erro capturado pelo catch
             * } catch (Exception e) {
             *     // Lidar com exceções
             *     System.out.println("Exceção capturada!");
             * }
             */
            //11
            } catch (Exception e) {}
        //12
        return result;}
}//fim da classe




package Produto;

public class Login {
    private static String usuario;
    private String senha;
    private static String cargo;

    public Login() {
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Login.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Login.cargo = cargo;
    }
    
    
}

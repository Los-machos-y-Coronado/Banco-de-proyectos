package edu.eci.cvds.samples.entities;

public class Like {

    private int iniciativa;
    private String correo;
    private boolean flag;

    public Like (int iniciativa,String correo,boolean flag){
        this.iniciativa=iniciativa;
        this.correo=correo;
        this.flag=flag;
    }
    public Like(){}

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Like{" +
                "iniciativa=" + iniciativa +
                ", correo='" + correo + '\'' +
                ", flag=" + flag +
                '}';
    }
}

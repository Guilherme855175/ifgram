package br.edu.ifpb.ifgram.model;

import jakarta.persistence.*;


import java.util.Optional;


@Entity
@Table(name = "usuario")
public class User {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false , length = 120)
    private String nome;

    @Column(nullable = false , unique = true)
    private String email;


    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int length() {
        return nome.length();
    }

    public String toLowerCase() {
        return nome.toLowerCase();
    }

    public String formatted(Object... args) {
        return nome.formatted(args);
    }

    public boolean contentEquals(StringBuffer sb) {
        return nome.contentEquals(sb);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        return nome.lastIndexOf(ch, fromIndex);
    }

    public boolean contains(CharSequence s) {
        return nome.contains(s);
    }



    public String indent(int n) {
        return nome.indent(n);
    }

    public String replace(char oldChar, char newChar) {
        return nome.replace(oldChar, newChar);
    }



    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return nome.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        nome.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public int lastIndexOf(String str) {
        return nome.lastIndexOf(str);
    }

    public Optional<String> describeConstable() {
        return nome.describeConstable();
    }


    public Object getImagemUrl() {
    }
}

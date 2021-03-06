package com.example.akhonin.bazilio;

import java.security.MessageDigest;

public class MD5Digest {

    public String main(String args) throws Exception {
        String original = args;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

}
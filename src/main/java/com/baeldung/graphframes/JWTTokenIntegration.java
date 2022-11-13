package com.folio;

import com.folio.claimset.*;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.JOSEException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.*;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.util.Map;

public class JWTTokenIntegration {

    public void generateAndVerifyJwtToken(JwtTokenUtility jwtTokenUtility) throws JOSEException, ParseException, KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, URISyntaxException {
        String token;
        RSASigningUtility signUtility = new RSASigningUtility();
        token = jwtTokenUtility.generteJWTToken(jwtTokenUtility.getRsaUtility());
        System.out.println(" ########################################## The Token generated     = "+token);
        System.out.println(" ########################################## The Token generated verfied back    = "+signUtility.verifyToken(token));
        Map<String, Object> claimSetmap =  jwtTokenUtility.getClaimSetFormToken(token);
        System.out.println(new GsonBuilder().create().toJson(claimSetmap));
    }

    public static void main(String[] args) throws ParseException, JOSEException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, URISyntaxException {
        JWTTokenIntegration integration = new JWTTokenIntegration();
        JwtTokenUtility jwtTokenUtility = new JwtTokenUtility();
        integration.generateAndVerifyJwtToken(jwtTokenUtility);
    }
}

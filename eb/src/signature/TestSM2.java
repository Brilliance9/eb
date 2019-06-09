package signature;

import org.bouncycastle.math.ec.ECPoint;

import transmission.Encapsulate;
import transmission.TransTool;

import java.math.BigInteger;

public class TestSM2 {

    public static void main(String[] args) {
        SM2 x = new SM2();
        SM2KeyPair keys = x.generateKeyPair();
        ECPoint pubKey = keys.getPublicKey();
        BigInteger privKey = keys.getPrivateKey();
        byte[] data = x.encrypt("nihao", pubKey);
        Encapsulate enc = new Encapsulate();
		TransTool tool = new TransTool();
		
		enc.encapsulate(data, 512);
		enc.printmsg();
        System.out.println("encrypt: " + data);
        String origin = x.decrypt(data, privKey);
        System.out.println("decrypt: " + origin);
    }
}

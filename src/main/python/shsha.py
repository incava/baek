from Crypto.Hash import SHA512
import binascii
from Crypto.Cipher import AES
from Crypto import Random

BLOCK_SIZE = 16
KEY_SIZE = 32
SALT_SIZE = 16


def aesEncrypt(message, key, iv):
    cipher = AES.new(key, AES.MODE_OFB, iv)
    return cipher.encrypt(message)


def aesDecrypt(encrypted, key, iv):
    cipher = AES.new(key, AES.MODE_OFB, iv)
    return cipher.decrypt(encrypted)


def inputPassword():
    password = input("Input Password for PBE:").encode('utf-8')
    print("Alice's password: %s" % password)
    return password


def inputMessage():
    message = input("Input Message for PBE:").encode('utf-8')
    print("Alice's Message: %s" % message)
    return message


def genKEK(salt, password):
    message = salt + password
    hash_Func = SHA512.new()
    hash_Func.update(message)
    keyKEK = hash_Func.digest()
    print("key KEK: ", keyKEK.hex())
    return keyKEK  # return keyKEK


def genCEK():
    keyCEK = Random.new().read(KEY_SIZE)
    print("key CEK: ", keyCEK.hex())
    return keyCEK  # return keyCEK


def encCEK(keyCEK, keyKEK, iv):
    encryptedCEK = aesEncrypt(keyCEK, keyKEK[:32], iv)  # iv + encrypted CEK
    """
    encryptedCEK = aesEncrypt(keyCEK) 
    """
    print("encrypted key CEK: ", encryptedCEK.hex())
    return encryptedCEK


def storeUSB(salt, encryptedCEK, iv, ciphertext, message):
    filename = input("USB Stored Filename(ex: PBE_Store.enc):")
    f = open(filename, 'wt')
    """
    salt + encrypted CEK + iv + cipherterxt + Hash
    """
    hpk = binascii.hexlify(salt) + '$*****$'.encode('utf8') \
          + binascii.hexlify(encryptedCEK) + '$*****$'.encode('utf8') \
          + binascii.hexlify(iv) + '$*****$'.encode('utf8') \
          + binascii.hexlify(ciphertext) + '$*****$'.encode('utf8') \
          + binascii.hexlify(SHA512.new(message).digest())
    ##
    #hs = binascii.hexlify(SHA512.new(message).digest())
    print("salt & encrypted CEK & iv & ciphertext & Hash :", hpk)
    f.write(hpk.decode('utf-8'))
    f.close()
    return hpk


def readUSB():
    filename = input("USB Stored Filename(ex: PBE_Store.enc):")
    f = open(filename, 'r')
    sf = f.readline()
    f.seek(0)
    salt, encryptedCEK, iv, ciphertext, HashValue = f.readline().split('$*****$')
    """
    convert hexdecimal string to byte !!!
    """
    salt = bytearray.fromhex(salt)
    encryptedCEK = bytearray.fromhex(encryptedCEK)
    iv = bytearray.fromhex(iv)
    ciphertext = bytearray.fromhex(ciphertext)
    HashValue = bytearray.fromhex(HashValue)

    print("salt: %s %d " % (salt, len(salt)))
    print("encryptedCEK: %s" % encryptedCEK)
    print("iv: %s %d" % (iv, len(iv)))
    print("ciphertext: %s" % ciphertext)
    print("HashValue: %s" % HashValue)

    f.close()
    return salt, encryptedCEK, iv, ciphertext, HashValue


def decCEK(encryptedCEK, keyKEK, iv):
    keyCEK = aesDecrypt(encryptedCEK, keyKEK[:32], iv)
    """
    keyCEK = aesDecrypt(encryptedCEK) 
    """
    print("decrypted key CEK: ", keyCEK.hex())
    return keyCEK


def PBE_Encryption():
    salt = Random.new().read(SALT_SIZE)
    print("PBE_Encryption salt: %s" % salt.hex())
    iv = Random.new().read(BLOCK_SIZE)
    print("PBE_Encryption iv: %s" % iv.hex())
    print("PBE_Encryption iv (length) : %d" % len(iv))

    alicePassword = inputPassword()
    keyKEK = genKEK(salt, alicePassword)

    message = inputMessage()
    keyCEK = genCEK()

    encryptedCEK = encCEK(keyCEK, keyKEK, iv)  # keyCEK --> 암호화하고자하는 message, keyKEY --> AES 암호화에 사용할 key, iv

    ciphertext = aesEncrypt(message, keyCEK, iv)
    print("AES Encrypted ciphertext: %s" % ciphertext.hex())
    hs=storeUSB(salt, encryptedCEK, iv, ciphertext, message)

    return ciphertext,hs


def PBE_Decryption(hs):
    alicePassword = inputPassword()
    salt, encryptedCEK, iv, ciphertext, HashValue = readUSB()
    keyKEK = genKEK(salt, alicePassword)
    decryptedCEK = decCEK(encryptedCEK, keyKEK, iv)
    plaintext = aesDecrypt(ciphertext, decryptedCEK, iv)
    print("AES Decrypted plaintext: %s" % plaintext)

    if HashValue == hs:
        print("Integrity Check OK!!!")
    else :
        print("Integrity Check Fail!!!")
    print("HashValue부분{}".format(HashValue))
    print("hs부분{}".format(hs))

    return plaintext


def main():
    print("*** PBE_Encryption ***\n")
    ciphertext,hs = PBE_Encryption()
    print("Encrypted Message: %s\n" % ciphertext)
    print("*** PBE_Decryption ***\n")
    plaintext = PBE_Decryption(hs)

    print("Final Message: %s" % plaintext.decode('utf-8'))


if "__main__" == __name__:
    main()

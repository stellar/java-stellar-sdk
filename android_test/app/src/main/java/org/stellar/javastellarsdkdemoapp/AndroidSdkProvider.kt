package org.stellar.javastellarsdkdemoapp

import org.stellar.sdk.Base32
import org.stellar.sdk.Base64
import org.stellar.sdk.spi.SdkProvider

class AndroidSdkProvider : SdkProvider {
    override fun createBase64(): Base64 {
        return AndroidBase64()
    }

    override fun createBase32(): Base32 {
        return AndroidBase32()
    }

    class AndroidBase64 : Base64 {
        override fun encodeToString(data: ByteArray?): String {
            return android.util.Base64.encodeToString(data, android.util.Base64.NO_WRAP)
        }

        override fun encode(data: ByteArray?): ByteArray {
            return android.util.Base64.encode(data, android.util.Base64.NO_WRAP)
        }

        override fun decode(data: String?): ByteArray {
            return android.util.Base64.decode(data, android.util.Base64.NO_WRAP)
        }
    }

    class AndroidBase32 : Base32 {
        private val base32: ApacheCodec.Base32 = ApacheCodec.Base32()

        override fun encode(data: ByteArray?): ByteArray? {
            return base32.encode(data)
        }

        override fun decode(data: String?): ByteArray? {
            return base32.decode(data)
        }

        override fun decode(data: ByteArray?): ByteArray? {
            return base32.decode(data)
        }

    }
}
package io.netty.channel.nio;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class aa {

	private static final char[] HEXDUMP_TABLE = new char[256 * 4];
	public static void main(String[] args) {
	     ByteBuffer direct = ByteBuffer.allocateDirect(1);
	        Field addressField;
	        try {
	            addressField = Buffer.class.getDeclaredField("address");
	            addressField.setAccessible(true);
	            if (addressField.getLong(ByteBuffer.allocate(1)) != 0) {
	                // A heap buffer must have 0 address.
	                addressField = null;
	            } else {
	                if (addressField.getLong(direct) == 0) {
	                    // A direct buffer must have non-zero address.
	                    addressField = null;
	                }
	            }
	        } catch (Throwable t) {
	            // Failed to access the address field.
	            addressField = null;
	        }
	}
}

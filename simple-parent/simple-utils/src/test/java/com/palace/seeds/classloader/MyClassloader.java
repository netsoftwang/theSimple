package com.palace.seeds.classloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyClassloader extends ClassLoader{
	
	
	static String basePath;
	static{
		URL url = MyClassloader.class.getClassLoader().getResource("");
		System.out.println("basePath："+url.getPath());
		basePath=url.getPath();
		File file=new File(basePath);
		basePath =file.getParentFile().getParentFile().getPath();
	}
	public MyClassloader(ClassLoader parent){
		super(parent);
	}
	public Class<?> load(String name, boolean resolve) throws ClassNotFoundException {
	   return super.loadClass(name);
   }

	  
	public static void main(String[] args) throws Exception {
		 MyClassloader loader=  new MyClassloader(MyClassloader.class.getClassLoader());
		 loader.read();
		
	}
	
	public void read(){
		for(String str: ClassFile.file){
			if(!"test".equals(str)){
				//String classPath = basePath+File.separator+"src\\test\\java\\"+str;
				byte[] b = f2b(str);
				Class<?> clazz = defineClass(str, b, 0, b.length);
			}
		}
	}
	private byte[] f2b(String fileName){  
        RandomAccessFile file = null;  
        FileChannel channel = null;  
        byte[] bytes = null;  
        try {  
            /**随机存取文件对象，只读取模式**/  
            file = new RandomAccessFile(fileName , "r");  
            /**NIO文件通道**/  
            channel = file.getChannel();  
            /**NIO字节缓冲**/  
            ByteBuffer buffer = ByteBuffer.allocate(1024);  
            int size = (int) channel.size();  
            bytes = new byte[size];  
            int index = 0;  
            /**从NIO文件通道读取数据**/  
            while (channel.read(buffer) > 0){  
                /**字节缓冲从写模式转为读取模式**/  
                buffer.flip();  
                while (buffer.hasRemaining()){  
                    bytes[index] = buffer.get();  
                    ++index;  
                }  
                /**字节缓冲的readerIndex、writerIndex置零**/  
                buffer.clear();  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally {  
            if (channel != null) {  
                try {  
                    channel.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (file != null) {  
                try {  
                    file.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return bytes;  
	 }
	
}

package fileSystemClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件类加载器的实现
 * 仍然选择了双亲委托机制，
 * @author 郝川
 *
 */
public class MyFileClassLoader extends ClassLoader{
	//        C:/my/
	private String rootDir;
	MyFileClassLoader(String rootDir){
		this.rootDir=rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//之前在这使用了findClass，出现了stackOverFlowError
		Class<?> c=findLoadedClass(name);
		
		if(c!=null){//已经被加载到命名空间,返回
			return c;
		}else{
			ClassLoader parent=this.getParent();
			
			/*
			 * 这里不一定得委托给双亲，也可以直接自己加载，没双亲什么事，也可以是自己加载不到，再委托给双亲
			 * 最终选择的是直接委托给双亲的做法，双亲加载不到，再自己加载
			 */
			try{
				c=parent.loadClass(name);//委派给父类加载
			}catch(Exception e){
				//e.printStackTrace();
			}
			if(c!=null){//如果父类可以加载
				return c;
			}else{//如果父类不能加载,自己加载
				
				//尝试获取字节码数据
				byte [] classData=getClassData(name);
				if(classData==null){//如果获取不到字节码信息,手动抛异常
					throw new ClassNotFoundException();
				}else{//获取到了字节码信息,defineClass(),导入类型到方法区
					c=defineClass(name, classData, 0, classData.length);
				}
			}
			
		}
		
		//萌萌哒的系统推荐的双亲委托机制
		//return super.findClass(name);
		return c;
	}
	//私有的getClassData，IO流获取字节码信息
	private byte[] getClassData(String classname){    //C:/my/
		//将包名中的.用/取代
		String path=rootDir+"/"+classname.replace('.', '/')+".class";
		InputStream ins=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try{
			ins=new FileInputStream(path);
			
			//读取字节码信息
			byte [] buffer=new byte[1024];
			int temp=0;
			//将读到的数据存到buffer中
			while((temp=ins.read(buffer))!=-1){
				//将buffer中的内容写出去
				baos.write(buffer, 0, temp);
			}
			//将输出流转成一个字节数组，返回
			return baos.toByteArray();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			/*
			 * 关闭流的处理
			 * 其实字节流可以不关，他没有打开底层的系统，但，还是关了吧...
			 */
			if(ins!=null){
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}







package fileSystemClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �Զ����ļ����������ʵ��
 * ��Ȼѡ����˫��ί�л��ƣ�
 * @author �´�
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
		//֮ǰ����ʹ����findClass��������stackOverFlowError
		Class<?> c=findLoadedClass(name);
		
		if(c!=null){//�Ѿ������ص������ռ�,����
			return c;
		}else{
			ClassLoader parent=this.getParent();
			
			/*
			 * ���ﲻһ����ί�и�˫�ף�Ҳ����ֱ���Լ����أ�û˫��ʲô�£�Ҳ�������Լ����ز�������ί�и�˫��
			 * ����ѡ�����ֱ��ί�и�˫�׵�������˫�׼��ز��������Լ�����
			 */
			try{
				c=parent.loadClass(name);//ί�ɸ��������
			}catch(Exception e){
				//e.printStackTrace();
			}
			if(c!=null){//���������Լ���
				return c;
			}else{//������಻�ܼ���,�Լ�����
				
				//���Ի�ȡ�ֽ�������
				byte [] classData=getClassData(name);
				if(classData==null){//�����ȡ�����ֽ�����Ϣ,�ֶ����쳣
					throw new ClassNotFoundException();
				}else{//��ȡ�����ֽ�����Ϣ,defineClass(),�������͵�������
					c=defineClass(name, classData, 0, classData.length);
				}
			}
			
		}
		
		//�����յ�ϵͳ�Ƽ���˫��ί�л���
		//return super.findClass(name);
		return c;
	}
	//˽�е�getClassData��IO����ȡ�ֽ�����Ϣ
	private byte[] getClassData(String classname){    //C:/my/
		//�������е�.��/ȡ��
		String path=rootDir+"/"+classname.replace('.', '/')+".class";
		InputStream ins=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try{
			ins=new FileInputStream(path);
			
			//��ȡ�ֽ�����Ϣ
			byte [] buffer=new byte[1024];
			int temp=0;
			//�����������ݴ浽buffer��
			while((temp=ins.read(buffer))!=-1){
				//��buffer�е�����д��ȥ
				baos.write(buffer, 0, temp);
			}
			//�������ת��һ���ֽ����飬����
			return baos.toByteArray();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			/*
			 * �ر����Ĵ���
			 * ��ʵ�ֽ������Բ��أ���û�д򿪵ײ��ϵͳ���������ǹ��˰�...
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







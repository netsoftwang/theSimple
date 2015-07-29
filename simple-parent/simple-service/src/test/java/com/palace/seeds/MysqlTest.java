package com.palace.seeds;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.palace.seeds.util.DateKit;
import com.palace.seeds.util.UUIDKit;



public class MysqlTest {

	Connection con;
	List<String> list;
	Random random=new  Random();
	@Before
	public void start() throws SQLException{
		con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:5106/seeds","root","111111");
		initStr();
	}
	
	 
	public String getMsg(){
		return list.get(random.nextInt(11));
	}
	@Test
	public void testInsertMsg() throws Exception{
		Statement st= con.createStatement();
		st.execute("insert into recordMsg(uuid,text,msg,createTime,updateTime)"
				+ " values('"+UUIDKit.getUsigned()+"',"
				+getMsg()+","
				+getMsg()+","
				+DateKit.getCurrent()+","
				+DateKit.getCurrent()+")");
		st.getResultSet();
	
	}
	
	
	
	@Test
	public void simpleTest(){
		print(UUIDKit.getUsigned());
		print(System.currentTimeMillis());
	}
	
	public static void print(Object str){
		System.out.println(str);
	}
	
	@Test
	public void initStr(){
		String centos="有两种方式。一种是二进制的发行方式，另外一种是源代码的发行方式。无论是哪一种发行方式，你都可以免费获得（例如从网上下载），"
				+ "并再次发布。但如果你使用了他们的在线升级（包括补丁）或咨询服务，就必须要付费。RHEL 一直都提供源代码的发行方式，CentOS "
				+ "就是将 RHEL 发行的源代码重新编译一次，形成一个可使用的二进制版本。由于 LINUX 的源代码是 GNU，所以从获得 RHEL 的源代码到编译成新的二进制，"
				+ "都是合法。只是 REDHAT 是商标，所以必须在新的发行版里将 REDHAT 的商标去掉。REDHAT 对这种发行版的态度是：我们其实并不反对这种发行版，"
				+"真正向我们付费的用户，他们重视的并不是系统本身，而是我们所提供的商业服务。所以，CentOS 可以得到 RHEL 的所有功能，甚至是更好的软件。但 CentOS "
				+ "并不向用户提供商业支持，当然也不负上任何商业责任。如果你要将你的 RHEL 转到 CentOS 上，因为你不希望为 RHEL 升级而付费。当然，"
				+ "你必须有丰富 linux 使用经验，因此 RHEL 的商业技术支持对你来说并不重要。但如果你是单纯的业务型企业，那么还是建议你选购 RHEL "
				+ "软件并购买相应服务。这样可以节省你的 IT 管理费用，并可得到专业服务。一句话，选用 CentOS 还是 RHEL，取决于你所在公司是否拥有相应的技术力量。CentOS，"
				+ "也叫做社区企业操作系统，是企业Linux发行版领头羊Red Hat Enterprise Linux（以下称之为RHEL）的再编译版本。RHEL是很多企"
				+ "业采用的Linux发行版本，但是如果想得到RedHat的服务与技术支持，用户必须向Red Hat付费才可以。CentOS的开发者们使用Red Hat Linux的"
				+ "源代码创造了一个和RHEL近乎相同的Linux。但是一切和RedHat有关的商标都被去除了，因为RedHat不允许他们这样做。CentOS是免费的，你可以使用它"
				+ "像使用RHEL一样去构筑企业级的Linux系统环境，但不需要向RedHat付任何的费用。CentOS的技术支持主要通过社区的官方邮件列表、论坛和聊天室";
		String ubuntu="Ubuntu由马克·舍特尔沃斯创立，其首个版本—4.10发布于2004年10月20日，它以Debian为开发蓝本。与Debian稳健的升级策略不同，"
				+ "Ubuntu每六个月便会发布一个新版，以便人们实时地获取和使用新软件。Ubuntu的开发目的是为了使个人电脑变得简单易用，同时也提供针对企业应用"
				+ "的服务器版本。Ubuntu的每个新版本均会包含当时最新的GNOME桌面环境，通常在GNOME发布新版本后一个月内发布。与其它基于Debian的Linux"
				+ "发布版，如MEPIS、Xandros、Linspire、Progeny和Libranet等相比，Ubuntu更接近Debian的开发理念，它主要使用自由、开源的软件，"
				+ "而其它发布版往往会附带很多闭源的软件。[2] Ubuntu建基于Debian的不稳定分支：不论其软件格式（deb）[1] 还是软件管理与安装系统（Debian "
				+ "Apt）。Ubuntu的开发者会把对软件的修改实时反馈给Debian社区，而不是在发布新版时才宣布这些修改。事实上，很多Ubuntu的开发者同时也是Debian"
				+ "主要软件的维护者。不过，Debian与Ubuntu的软件并不一定完全兼容，也就是说，将Debian的包安装在Ubuntu上可能会出现兼容性问题，反之亦然。";
		
		String debian="广义的Debian是指一个致力于创建自由操作系统的合作组织及其作品，由于Debian项目众多内核分支中以Linux宏内核为主，而且 Debian开发者 "
				+ "所创建的操作系统中绝大部分基础工具来自于GNU工程 ，因此 “Debian” 常指Debian GNULinux。非官方内核分支还有只支持x86的Debian"
				+ " GNU/Hurd（Hurd微内核），只支持amd64的Dyson（OpenSolaris混合内核）等。这些非官方分支都存在一些严重的问题，没有实用性，比如Hurd"
				+ "微内核在技术上不成熟，而Dyson则基础功能仍不完善。Debian” 正式发音为 ˈdɛ.bi.ən ，Debian 是国际化协作项目，官方未指定任何非英文名称。";
		String fedora="Fedora 是一个知名的Linux发行版，是一款由全球社区爱好者构建的面向日常应用的快速、稳定、强大的操作系统。它允许任何人自由地使用、修改和重发布，"
				+ "无论现在还是将来。它由一个强大的社群开发，这个社群的成员以自己的不懈努力，提供并维护自由、开放源码的软件和开放的标准。Fedora 项目由 Fedora 基金会"
				+ "管理和控制，得到了 Red Hat, Inc. 的支持。Fedora 是一个独立的操作系统，可运行的体系结构包括 x86（即i386-i686）, x86_64 和 PowerPC。"
				+ "Fedora （第七版以前为Fedora Core）是一款基于 Linux 的操作系统，也是一组维持计算机正常运行的软件集合。Fedora 由Fedora Project社区开发"
				+ "、红帽公司赞助，目标是创建一套新颖、多功能并且自由和开源的操作系统。Fedora 项目以社区的方式工作，引领创新并传播自由代码和内容，是世界各地爱好、使用和构"
				+ "建自由软件的社区朋友的代名词。[1] "
				+ "Fedora基于Red Hat Linux，在Red Hat Linux终止发行后，红帽公司计划以Fedora来取代Red Hat Linux在个人领域的应用，而另"
				+ "外发行的Red Hat Enterprise Linux（Red Hat企业版Linux，RHEL）则取代Red Hat Linux在商业应用的领域。"
				+ "Fedora的功能对于用户而言，它是一套功能完备、更新快速的免费操作系统，而对赞助者Red Hat公司而言，它是许多新技术的测试平台，被认为"
				+ "Fedora大约每六个月发布新版本。目前Fedora最新的稳定版本是Fedora 22 。在Fedora 7之前，有Core和Extras两个主要的仓库。Fedora"
				+ " Core仓库包含所有操作系统必需的基本软件包，以及其他随安装CDDVD发行的、由Red Hat开发者维护的软件包。Fedora Extras仓库自Fedora Core 3开始加"
				+ "第三方软件仓库主要用于发布未包含在Fedora中的软件包——可能因为不满足Fedora对自由软件的定义，或该软件包的发行会触犯美国法律。主要的第三"
				+ "方软件仓库（并且是完全兼容的）有RPM Fusion和Livna。前者是由许多第三方软件仓库维护者共同维护的。后者仍然独立维护，作为对RPM Fusion的扩"
				+ "展，并且只包含libdvdcss包，用于播放加密的DVD。";
		String suse="2005年8月4日，Novell公共关系科的领导及代言人 － Bruce Lowry表示，SUSE Linux Professional系列的开发将变得更开放以及让社群参与"
				+ "当中的工作。新的开发计划名为openSUSE，目的是为了吸引更多的使用者及开发人员。 相比以往，现在所有的开发人员及使用者能够测试SUSE的产品并一起开发新版"
				+ "本的SUSE。在以往，SUSE的开发工作都是于内部进行的。SUSE 10.0是第一个给予公众测试的版本。为了配合这个转变，用户除了能够购买盒装版本的SUSE外，"
				+ "也可以从网络上免费下载。一系列的改变让于2005年 10月6日推出的SUSE Linux有三个版本 － OSS版 (完全地开放原始码)、试用版(同时包含开放原始码的程"
				+ "序及专属程序如Adobe Reader、Real Player等，其实就是盒装零售版，也可以免费下载，可以安装在硬盘上，并且没有使用限制或限期，但不含说";
		String redhat="IT managers value Red Hat Enterprise Linux for the robustness, security, stability, high "
				+ "performance, and scalability it delivers to their organizations. Red Hat Enterprise Linux Desktop "
				+ "and Red Hat Enterprise Linux Workstation bring the power and innovation of the world's leading enter"
				+ "prise Linux platform to the desktop. Whether you’re a business user, developer, or systems administrator"
				+ ", there's an edition of Red Hat Enterprise Linux to meet your needs.";
		String jdk="These instructions use the following file:jdk-8uversion-linux-i586.rpmDownload the fil"
				+ "e.Before the file can be downloaded, you must accept the license agreement.Become root by ru"
				+ "nning su and entering the super-user password.3. Uninstall any earlier installations of the J"
				+ "DK packages.# rpm -e package_nameInstall the package.# rpm -ivh jdk-8uversion-linux-i586.rpmTo upgrade"
				+ " a package:# rpm -Uvh jdk-8uversion-linux-i586.rpmExit the root shell. No need to reboot.5. "
				+ "Delete the .rpm file if you want o save disk space.Starting with version 8u40, the JDK installa"
				+ "tion is integrated with the alternatives framework and after installation, the alternatives framew"
				+ "ork is updated to reflect the binaries from the recently installed JDK. Java commands such as java"
				+ ", javac, javadoc, and javap can be invoked from the command line.Using the java -v"
				+ "ersion command, users can confirm the default (recently installed) JDK version.";
		String tomcat ="Apache Tomcat™ is an open source software implementation of the Java Servlet, JavaServer P"
				+ "ages, Java Expression Language and Java WebSocket technologies. The Java Servl"
				+ "et, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed und"
				+ "er the Java Community Process.Apache Tomcat is developed in an open and participatory environment "
				+ "and released under the Apache License version 2. Apache Tomcat is intended to be a collaboration of "
				+ "the best-of-breed developers from around the world. We invite you to participate in this open "
				+ "development project. To learn more about getting involved, click here.";
		String ant="Apache Ant is a Java library and command-line tool whose mission is to drive processes described "
				+ "in build files as targets and extension points dependent upon each other. The main known usage of "
				+ "Ant is the build of Java applications. Ant supplies a number of built-in tasks allowing to compile, "
				+ "assemble, test and run Java applications. Ant can also be used effectively to build non Java applications,"
				+ " for instance C or C++ applications. More generally, Ant can be used to pilot any type of process which ca"
				+ "n be described in terms of targets and tasks.Ant is written in Java. Users of Ant can develop their own"
				+ " antlibs containing Ant tasks and types, and are offered a large number of ready-made commercial or open-source";
		String apache="The 2.0 version of the Apache License was approved by the ASF in 2004. The goals "
				+ "of this license revision have been to reduce the number of frequently asked questions,"
				+ " to allow the license to be reusable without modification by any project (including non-ASF pr"
				+ "ojects), to allow the license to be included by reference instead of listed in every file, to "
				+ "clarify the license on submission of contributions, to require a patent license on contributions "
				+ "that necessarily infringe the contributor's own patents, and to move comments regarding Apache and"
				+ " other inherited attribution notices to a location outside the license terms (the NOTICE file ).The "
				+ "result is a license that is supposed to be compatible with other open source licenses, while remaini"
				+ "ng true to the original goals of the Ap";
		list=new ArrayList<String>();
		list.add(centos);
		list.add(ubuntu);
		list.add(debian);
		list.add(fedora);
		list.add(suse);
		list.add(redhat);
		list.add(tomcat);
		list.add(ant);
		list.add(apache);
		list.add(jdk);
		
		List<String> newList=new ArrayList<String>();
		for(String str :list){
			str=str.replace("'", "aaa");
			newList.add(str);
		}
		list=newList;
		
	}
}

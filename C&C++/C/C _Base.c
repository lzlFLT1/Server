//程序调试方法：
1、设置并执行print、cout等能直观看见的命令进行程序测试
2、逐行执行或设置断点执行程序；查看断点处各个变量的值与预期值比较；重复此过程

/*标识符命名惯例：
 *常量（const）：全部大写
 *类：大驼峰HumanBoy
 *方法：小驼峰getName
 *局部变量：小驼峰
 */
 
/*C&C++ 变量、对象使用步骤：声明 -> 定义（分配内存）-> 调用。
 *C&C++ 变量定义的理解：
 *定义可以看成两种：类型定义，数据定义
 *类型定义不分配内存的，比如类的定义，结构体的定义，它是定义一个数据类型而已
 *数据定义分配内存，比如类对象定义，基本类型变量定义（包括指针，但是指针如果指向的内存地址没有被分配是无法保存内容的）
 *一个原则：
 *不分配内存的，放在头文件
 *分配内存的放在cpp文件，防止重复定义
 */
 
 /*自动类型转换（即隐式转换：这tm的是个坑爹的玩意儿）
 *1、类型相同，运算结果出现其他类型，将继续保持原类型（如 int / int，出现小数时，将自动转化为 int 造成精度降低）
 *   c = (double)(2/3)  c = 0.000  而  c = ((double)2/3)  c = 0.6666  说明 运算结果的 隐式转换 早于 强制转换
 *2、参与运算的数据类型不同，必须先转换成同一类型，才能进行运算；
 *   按数据长度增加的方向进行，以保证精度不降低。低字节-->高字节   有符号-->无符号
 *3、所有的浮点运算都是以双精度进行的，即使仅含float单精度量运算的表达式，也要先转换成double型，再作运算。
 *4、char型和short型参与运算时，必须先转换成int型。
 *5、在赋值运算中，赋值号两边量的数据类型不同时，赋值号右边量的类型将转换为左边量的类型。
 *   如果右边量的数据类型长度左边长时，将丢失一部分数据，这样会降低精度，丢失的部分按四舍五入向前舍入。
 */
 
/*条件编译：……………………………………………………………………………………………………………… */
#ifdef 标识符
	程序段1
#else 
	程序段2
#endif

#ifndef 标识符//当标识符没有被定义过时，编译程序段1
	程序段1
#else 
	程序段2
#endif

#if 表达式//当表达式值为真时，编译程序段1
	程序段1
#else 
	程序段2
#endif

/*宏定义：……………………………………………………………………………………………………………*/
	#define PI 3.1415926 //符号常量：原样替换
	#define S(a,b) (a*b)//#define 宏名（参数表）  字符串
	#define NULL 0
	#define EOF -1

	
/*文件包含：……………………………………………………………………………………………………………*/
	#include<stdio.h>
	#include<stdlib.h>
	#include<string.h>
	#include"myfile.c"

	
/*全局变量：…………………………………………………………………………………………………………………………………………………………………………………………………………*/  
	extern int ABB;//调用其他文件中的ABB全局变量必须先敲这段代码	
	
	
/*函数声明（包含本项目中其他文件中的函数时,必须使用extern关键字）：…………………………………………………*/
	extern int JieCheng(int s); //在文件中调用其他文件的函数时必须加上此代码
	
	
/*程序主体：………………………………………………………………………………………………………………*/
int main(int argc,char *argv[]){return 0;}
/* main的两个参数从OS命令行中获得
	argc参数表示了命令行中参数的个数(注意：文件名本身也算一个参数)
	argc的值是在输入命令行时由系统按实际参数的个数自动赋予的，
	argv[0] 存储程序的名称，argv[1] 是一个指向第一个命令行参数的指针
	如果没有提供任何参数，argc 将为 1，否则，如果传递了一个参数，argc 将被设置为 2
	如果参数本身带有空格，那么传递参数的时候应把参数放置在双引号 "" 或单引号 '' 内部
*/


// C 数据类型
	char ch = '\r';
	int i;
	double d = -1.23e-6;
	enum color{red=0, green=1, blue=9};
	char chs[9];
	struct String
	{
		int i;
		char ch;
	};
	union share
	{
		char ch;
		int i;
		double d;
	};
	int **p;//二级指针：谨记：'='号左边是该地址所表示的内存空间；'='号右边是该地址内存空间中存的内容
	void 

	
// C 数组
	char str[9];
	char str[]="hello world!";//自动 '\0' 作为字符串结尾，或赋值给未赋值的元素
	char str[]={'h', 'e', 'l', 'l', 'o'};
	int a[2][3]={{0, 1, 2}, {3, 4, 5}};//部分赋初值，未赋值元素自动取0。

	/*********************** 数组名 和 指针 的区别 *****************
	char* p = str;  
	//首先数组名可以直接赋值给指针，而指针存的是地址，那就说明数组名并不是指针，而是直接内存地址
	//而指针的内存结构是 [地址, 内容]，也就是说 数据名 直接就是指针中内容，没有专门的开辟一个内存地址给数组名
	//用汇编语言解释就是：数组名直接就给映射成一个固定的内存地址了
	*/
	
// C 指针
	int *p = NULL;
	p = &i;
	
	int a[3][4];
	int (*p)[4];//二维数组行指针，p+1 其实移动 sizeof(int)*4 个字节
	*(*(p+i)+j)//相当于 a[i][j]
	
	int (*funp)();//函数指针
	funp = funName;
	(*funp)();//相当于 funName()


// C 输入输出
	printf("请输入数据（字符,整数,浮点数,字符串）：");
	scanf("%c,%d,%s,%f",&c,&d,&str,&f);//任何空白符都是字符串结束标志
	printf("\n输入值为：字符：%c，整数：%d，浮点数：%f，字符串：%s，打印%：%%",c,d,f,str);

	printf("\n请输入一个字符！：");
	c = getchar();//从流中读入一个字符
	putchar(c);//输出一个字符

	printf("\n请输入一个字符串！：");
	gets(str);//只有“回车”才是字符串的结束标志
	puts(str);

	printf("\n请输入一个不需要回车即接收的字符！：");
	c = getch();//不需要回车即接收，#include<conio.h>
	printf("\n请输入一个不需要回车即接收,并回显的字符！：");
	c = getche();//不需要回车即接收，并回显,#include<conio.h>

// C 程序流程控制
	if(){}
	else if(){}
	else{}

	switch()
	{
		case 1:{break;}
		case 'a':{break;}//如果缺少break会将之后的case代码一起执行，直到遇到break或者switch结束
		default:{break;}
	}

	while(){}

	do
	{}
	while();

	for(;;){}

	goto LOOP;	


// C 字符串处理
	#include<string.h>
	int i = strlen(str);
	char *p_str1 = strcat(str1, str2);
	char *p_str1 = strcpy(str1, str2);
	int i = strcmp(str1, str2);
	char *p_str = strupr(str);
	char *p_str = strlwr(str);

	
// C 变量作用域和生命周期
	int Global;
	/*全局变量：所有源文件皆可使用；在别的文件使用时需先用extern int a;重新声明才可使用;
	 *生存周期：程序开始运行到结束;
	 */ 

	static int Static_Global;
	/*静态全局变量：仅可在本文件中使用的全局变量；
	 *生存周期：程序开始运行到结束；
	 */
	 
	int fun()
	{
		register char str[9];//一个字符串
		/*普通局部变量：仅在本函数中使用；且可以定义为 register 变量
		 *生存周期；本函数开始执行到结束；
		 */
		
		static int Static_d;
		/*静态局部变量：仅在本函数中使用，其他函数不能使用该变量；
		 *生存周期：程序开始运行到结束；
		 *特性：只初始化一次，默认值为0；
		 */
		 
		const float pi = 3.1415926 ////constant类型：表示赋值一次后不能再次对值进行修改,常变量：变量存在期间其值不能改变	
	}

	
// C 函数定义
	/* 函数定义格式：
		返回类型 函数调用方法  函数名(参数类型 参数1，参数类型 参数2，...){}
		int __stdcall funName(char c, int arry[], ...){}

		函数调用方法：
		用于说明在参数传递中的两个重要：
		1. 当参数个数多于一个时，按照什么顺序把参数压入堆栈；
		2. 函数调用后，由谁来把堆栈恢复原状。

		__cdecl  C语言默认函数调用方法
		__stdcall C++默认函数调用方法
	*/
	int fun1(){}//常规函数
	static int fun2(char str[][3]){}//静态函数：只限于本文件中使用
	
	/* C 可变长参数函数定义 
	#include <stdarg.h>  //1、包括stdarg.h头文件

	double average(int num,...)
	{

		va_list valist;  //2、设置 va_list 类型变量 valist
		double sum = 0.0;
		int i;

		// 3、使用 int 参数和 va_start 宏来初始化 va_list 变量为一个参数列表
		va_start(valist, num);

		// 4、使用 va_arg 宏和 va_list 变量来访问参数列表中的每个项 
		for (i = 0; i < num; i++)
		{
		   sum = sum + va_arg(valist, i);
		}
		// 5、使用宏 va_end 来清理赋予 va_list 变量的内存 
		va_end(valist);

		return sum/num;
	}	
	*/

	
// C 用户自定义类型
	typedef int MyInt;
	MyInt i;
	
	typedef double ARRAY[9];
	ARRAY a;//等同于 double a[9];
	
	typedef char *PTR;
	PTR p;//等同于 char *p;
	
	typedef struct
	{
		
	}String, *PString;
	String str;//等同于struct ? str;
	
	typedef int (*FP)();
	FP func;//等同于 int (*func)(); 

	
// C 位段
	//1、位段类型必须是 unsigned 或 int 型，输出以整数的形式输出
	//2、长度为n的位段赋值范围：0~(2^n)-1
	//3、一个位段必须存储在同一个字节中，不能跨两个字节。如果第一个字节不够，则该空间不用，从下一个字节开始存放该位段
	//4、无名位段，表示相应空间不用，长度为0的无名位段，表示下一个位段从下一个字节开始存放
	struct packed_bit
	{
		unsigned a:2;
		unsigned b:4;
		unsigned :0;//长度为0的无名位段：下一个位段从下一个字节开始存放
		unsigned c:3;
		unsigned :3;//无名位段：这 3bit 空间不用
		unsigned d:2;
	}data;

	
// C 动态内存分配
	void * malloc(unsigned size);
	void *calloc(unsigned n, unsigned size);//分配n个size大小的连续内存单元，失败返回 NULL
	void free(void *ptr);

	
// C 文件
	FILE *fp;
	fb = fopen("e:/filename", "w+");
	/*FILE* fopen(文件名，使用文件方式)；
		*打开方式：
		*t：以文本方式打开文件（默认）
		*b:以二进制方式打开文件
		******
		*r：以只读方式打开文件，文件若不存在返回错误信息
		*w：以只写方式打开文件，文件不存在则新建，文件存在，删掉再新建
		*a：以添加方式打开文件，打开文件时位置指针在文件尾，用于添加内容；文件不存在则新建
		*r+:读写方式打开，位置指针在文件头，不存在则新建
		*w+：读写方式创建一个新文件
		*a+：读写方式打开，位置指针在文件尾
	*/
	/*文件指针：stdin指向键盘
			  ：stdout指向显示器
			  ：stderr指向显示器
	*/
	exit(0);//正常退出，返回控制权给 OS。
	int i = fclose(fb);//0 正常；EOF(-1) 失败
	int i = feof(fp);//1 文件尾 0 不是文件尾
	char ch = foutc(ch, fp);//ch 成功 EOF 失败
	char ch = fgetc(fp);//EOF 失败；执行后 “读写指针后移到下一个字符”
	fputs(str, fp);
	fgets(str, fp);
	int i = fwrite(buffer, size, count, fp);//1 成功
	int i = fread(buffer, size, count, fp);//1 成功
	fscanf(fp, "%s", &str);//从文件读取
	fprintf(fp, "%s", str);//向文件输出

	rewind(fp);//读写指针回到文件头
	fseek(fp, 偏移量（可负）, 起始点);
	long l = ftell(fp);//返回当前读写指针位置 -1 出错
	int i = ferror(fp);//0 没出错
	clearerr(fp);//将ferror() 和 feof() 置0


// C 运算符
x>y?100:50;   条件运算符
(int) 强制类型转换
sizeof(double) 求该类型字节数
! 非
& 取地址
* 取内容
~ 按位取反
^ 按位异或（同0异1）

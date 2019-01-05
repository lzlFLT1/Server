/////////////        C++文件和流      /////////////////////////
#include<iostream>
cin>>
cout<<

#fstream
ifstream obj;
ofstream obj;
fstream obj;

obj.open("URI", ios::out | ios::trunc);//打开文件
/*
ios::app	追加模式。所有写入都追加到文件末尾。
ios::ate	文件打开后定位到文件末尾。
ios::in		打开文件用于读取。
ios::out	打开文件用于写入。
ios::trunc	如果该文件已经存在，其内容将在打开文件之前被截断，即把文件长度设为 0 
*/

obj>>// 从文件读取数据
obj<<// 向文件写入数据

//文件位置指针定位
pbj.bseekg(int n, ios::beg);//仅适用ifstream对象
obj.seekp(int n, ios::cur/*ios::end*/);//仅适用ofstream对象

obj.close();//关闭文件



/////////////        C++动态内存     /////////////////////////
char* str_ptr;//1、定义存储地址的指针
str_ptr = new char[20];//2、为变量请求内存
delete [] str_ptr;//3、释放 str_ptr 所指向的内存

/////////////        C++命名空间     /////////////////////////
namespace MyNameSpace //定义命名空间
{
	void myfun(){}
	namespace MyNameSpace2
	{
		
	}
}
namespace AA
{
	/* 
	该代码表示：
	如果AA命名空间不存在，则定义命名空间AA
	如果AA命名空间已存在，则表示向AA命名空间内添加元素
	*/
}

MyNameSpace::myfun();//命名空间的使用，跟类差不多

using namespace MyNameSpace;//这个指令会告诉编译器，后续的代码将使用指定的命名空间中的名称,直到下一个这种指令出现为止
using MyNameSpace::cout;//随后的代码中，在使用 cout 时就可以不用加上命名空间名称作为前缀，但是 std 命名空间中的其他项目仍然需要加上命名空间名称作为前缀

using namespace MyNameSpace::MyNameSpace2;//嵌套命名空间的使用



/////////////        C++模板     /////////////////////////
//模板函数定义
template <typename T1,class T2,…>//T：类属参数；T1,T2:模板参数
T1 gg(T1 a,T2 b,int c)//模板参数不进行默认类型转换，如果实参与形参类型不匹配，则出错
{
	
}

//模板函数调用
gg((double)(2),3.2,7);//调用时显示类型转换
gg<double>(2,3.2,7);//这种方式将参数全部转换为double型
gg<double,int>(2,3.2,7);//具有多个不同模板参数时，在<>中分别指定各模板参数的类型


//模板类定义
template <typename T>
struct ListNode
{
	T data;
	ListNode<T> *next;//注意ListNode的指针声明格式 ，有一个<T>跟在后面；模板中调用其他类模板时，调用格式为：其他类模板名<T>
};


//template <typename T1,class T2,int T3,…>
template<typename T>
class List
{
	char getname(){}//在类模板内定义函数与普通类内一样
	int getlength();
};

template<typename T1,typename T2,int T3>//在类模板外定义成员函数
inline int X<T1,T2,T3>::getlength(T1 t,int n)
{}


////类模板实例化:当用类模板定义对象时，将引起实例化，在实例化中，如果模板参数是T，则必须为它指定具体的类型，若是非T，则必须为它制定一个常量值/////////////
List<int> intList;//实例化语句，模板参数为T，必须换成如语句中的<int>


/////////////        C++预处理     /////////////////////////
#define MKSTR( x ) #x  //#把字符串用""包含   即#x  == "x"
#define CONCAT( x, y )  x ## y //##用于连接两个字符串   即 x##y  == xy
#define f(x, y) (x*y)  //包含表达式必须包含在括号里面

__LINE__	这会在程序编译时包含当前行号。
__FILE__	这会在程序编译时包含当前文件名。
__DATE__	这会包含一个形式为 month/day/year 的字符串，它表示把源文件转换为目标代码的日期。
__TIME__	这会包含一个形式为 hour:minute:second 的字符串，它表示程序被编译的时间。

/////////////        C++ typedef     /////////////////////////
/* 
（4）typedef也有一个特别的长处：它符合范围规则，使用typedef定义的变量 
	 类型其作用范围限制在所定义的函数或者文件内（取决于此变量定义的位置），而宏定义则没有这种特性
（5）对复杂变量建立一个类型别名的方法很简单，你只要在传统的变量声明表达式里用类型名替代变量名，然后把关键字typedef加在该语句的开头就行了。 
*/
//typedef type   newName
typedef int int_32;//基本类型
typedef char Str69[69];//数组
str69 aa,bb;//== char aa[69]; char bb[69]
typedef  char* pStr;//指针
const pStr aa;
/* 
注意 该代码不等价于   const char* aa   而是等价于   char* const aa
原因在于  不能把typedef 当做#define一样 进行文本扩展，声明const pStr 时，const 是修饰 pStr 这个类型，而这个类型是一个指针，造成出错
*/
typedef int (*pFun) (const char *, const char *);//函数
typedef struct node
{
	int a;
}JieDian;//结构体
typedef struct node JieDian;//结构体


/////////////        C++多线程     /////////////////////////


///////////////////////////////运行时类型信息////////////////////
dynamic_cast<目标类型>(表达式)//把一种类型的指针或引用转换成另一种类型的指针或引用；指针转换失败返回‘0’，引用失败，引发异常

	Base *pb,b;
    Derived *pd,d;
	pb=&d;//编译时完成
	pd=dynamic_cast<Base*>(*d);//运行时确定
	/*dynamic_cast注意事项
	 *1、用dynamic_cast进行基类与子类指针或引用之间转换时，基类必须至少有一个虚函数
	 *2、只有支持RTTI的程序环境中才能使用
	 *3、向下转换：将基类指针转换成子类指针时，只有该指针最初指向的是子类的对象才可转换成子类指针
	 */

	typeid(exp);//该操作返回一个type_info类对象的引用，其中typeid和type_info都是定义在头文件typeinfo中定义的，用typeinfo类的成员函数name()获得exp的类型名称
    //使用限定：当子类对象赋值给基类对象或把基类对象的指针或引用指向子类对象时，基类必须有虚函数，否则返回的是基类类型
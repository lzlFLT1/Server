///////////////异常处理：try、throw、catch///////////////////////////////////////////////
/*异常处理流程：
 *如果try块中某条语句用throw抛出了异常，则程序控制流程将throw子句转移到catch块，try块中throw后面的语句都不执行
 *C++将按catch块出现的顺序，用异常数据类型匹配catch块中的形参，如果两者相同，则执行该catch块，同时吧异常值传给catch块的形参
 *如果catch块没有匹配成功的，则C++调用默认的异常处理程序，通常是直接终止程序
 */

///////////////////////////////////异常基础////////////////////////////////
void main()
{
	try
	{
		try/////////////异常的嵌套
		{
			if()//测试错误条件，如果出错则抛出异常
			{
				throw  100;
			}
		}
		catch(int i)//如果进入throw则100会传递给i变量
		{
			//语句
		}
		catch(char& ch)//catch中每个参数类型必须不同；捕获char类型的异常
		{
	
		}
		catch()//捕获任何类型的异常
		{
			throw;//没有任何参数的throw表示：该异常被抛给外层try语句
		}
	}
	catch(){}
}


///////////////////////异常与函数///////////////////////////////
void temp1(int t)//在函数中处理异常
{
	try
	{
		if(t==100)throw "沸点";
		else if(t==0)throw "冰点";
		else cout<<"temp is OK";
	}
	catch(int x)
	{
		cout<<"temp="<<x<<endl;
	}
	catch(char *s)
	{
		cout<<s<<endl;
	}

}

void temp2(int t)
{
	if(t==100)throw "沸点";
		else if(t==0)throw "冰点";
		else cout<<"temp is "<<t<<endl;
}

void main()
{
	temp1(0);
	temp1(10);
	temp1(100);//在函数中处理异常，调用格式

	try
	{
		temp2(0);
		temp2(10);
		temp2(100);
	}
	catch(char *s)
	{
		cout<<s<<endl;
	}/////////////////////在函数调用中完成异常处理，调用格式
}


//////////////////////异常与类////////////////////////
//异常可以是任何类型的数据包括“类”
	try
	{
		throw X();//抛出异常类X;调用X构造函数构造一个临时对象t，
	}
	catch(X x)//调用X类的复制构造函数，用临时对象t给x初始化
	{}

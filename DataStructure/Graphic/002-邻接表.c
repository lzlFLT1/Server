/*预编译：……………………………………………………………………………………………………………… */


/*宏定义：……………………………………………………………………………………………………………*/


/*头文件包含：……………………………………………………………………………………………………………*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"MyCode"

/*全局变量：………………………………………………………………………………………………………………*/  
struct Enode//边结点
{
	int adjvertex;//邻接点域
	DT info;//边上信息：即权
	struct Enode* next;//指向下一个邻接点的指针
};

struct Vnode//顶点结点
{
	VertexType vertexl;//顶点域
	struct Enode *firstEdge;//边表头指针
};

struct TU_ljb//邻接表存储的图
{
	struct Vnode adjlist[MaxVertexNum];//邻接表
	int VertexNum;//顶点个数
	int EdgeNum;//边 条数
};


/*函数声明：………………………………………………………………………………………………………………*/


/*功能说明：
 *参数含义：
 *返回值含义： 
 */ 

/*程序主体：………………………………………………………………………………………………………………*/


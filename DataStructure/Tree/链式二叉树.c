/*预编译：……………………………………………………………………………………………………………… */


/*宏定义：……………………………………………………………………………………………………………*/
#define DT char 

/*头文件包含：……………………………………………………………………………………………………………*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"MyCode"
#include"SeqStack.c"

/*全局变量：………………………………………………………………………………………………………………*/  
struct BTnode
{
	struct BTnode *parent,*lChild,*rChild;//结点的双亲、左孩子、右孩子指针
	DT data;//结点内容
};

/*函数声明：………………………………………………………………………………………………………………*/

struct BTnode *BTnodeCreat();
/*功能说明：创建一个二叉树节点 
 *参数含义：
 *返回值含义：返回该结点的指针 
 */ 
 
struct BTnode *BTCreat(DT array[]); 
 /*功能说明：按先序(根左右)遍历输入字符序列，没有左右孩子用#表示 
 *参数含义：array（输入的字符序列） 
 *返回值含义： 创建树的根节点指针 
 */ 
 
void BTBianLIX(struct BTnode *pBT);
 /*功能说明：先序遍历二叉树  非递归算法 
 *参数含义：
 *返回值含义： 
 */ 
 void BTBianLiXRecursion(struct BTnode *pBT)； 
 /*功能说明：先序遍历二叉树  递归算法 
 *参数含义：
 *返回值含义： 
 */ 

void BTBianLIZ(struct BTnode *pBT); 
/*功能说明：中序遍历二叉树  非递归算法 
 *参数含义：
 *返回值含义： 
 */ 
 void BTBianLiZRecursion(struct BTnode *pBT)
/*功能说明：中序遍历二叉树  递归算法 
 *参数含义：
 *返回值含义： 
 */ 
 void visit(struct BTnode *pBT);
/*功能说明：访问该结点数据 
 *参数含义：
 *返回值含义： 
 */ 
 void BTBianLIC(struct BTnode *pBT);
/*功能说明：层序遍历算法
 *参数含义：
 *返回值含义： 
 */ 
/*程序主体：………………………………………………………………………………………………………………*/


/*二叉树性质： 
 *1、任意二叉树，如果度为0的结点的个数为n0，度为2的结点的个数为n2，则n0=n2+1; 
 */ 
struct BTnode *BTnodeCreat()
{
	struct BTnode *pBT = NULL;

	pBT = (struct BTnode *)malloc(sizeof(struct BTnode));

	if(pBT)
	{
		pBT->parent = NULL;
		pBT->lChild = NULL;
		pBT->rChild = NULL;
		pBT->data = '@';
	}
	return pBT;
}



struct BTnode * BTCreat(DT array[])
{
	int i = 0;
	struct BTnode *root = NULL;
	struct BTnode *pBT = NULL;
	struct BTnode *pBT1 = NULL;
	struct sequenceStack *s;
	
	s = sequenceStackCreat();//创建一个栈	
		
	while(array[i] != '\0')
	{
		if(i == 0)
		{
			root = BTnodeCreat();
			root->data = array[i];
			sequenceStackPush(s,root);
		}			
		else if(array[i] != '#')
		{
			sequenceStackGetTop(s,&pBT);
			pBT1 = BTnodeCreat();
			pBT->lChild = pBT1;
			pBT1->parent = pBT;
			pBT1->data = array[i];
			sequenceStackPush(s,pBT1);
		}
		else
		{
			i++;
			sequenceStackPop(s,&pBT);
			if(array[i] != '#')
			{		
				pBT1 = BTnodeCreat();
				pBT->rChild = pBT1;
				pBT1->parent = pBT;
				pBT1->data = array[i];
				sequenceStackPush(s,pBT1);
			}	
			else
			{
				i++; 
				sequenceStackPop(s,&pBT);	
				if(array[i] != '#')
				{					
					pBT1 = BTnodeCreat();
					pBT->rChild = pBT1;
					pBT1->parent = pBT;
					pBT1->data = array[i];
					sequenceStackPush(s,pBT1);
				}
			}	
		}
		i++;
	}
	return root;
} 



void BTBianLIX(struct BTnode *pBT)//先序遍历非递归算法 
{
	struct sequenceStack *s;
	
	while(pBT != NULL || sequenceStackEmptyFull(pBT) == 0)
	if(pBT != NULL )
	{
		visit(pBT->data);
		sequenceStackPush(s,pBT);	
		pBT = pBT->lChild;
	}
	else
	{
		sequenceStackPop(s,&pBT);
		pBT = pBT->rChild;
	}
	sequenceStackDestory(s);
}

void BTBianLiXRecursion(struct BTnode *pBT)//先序遍历递归算法 
{
	if(pBT != NULL)
	{
		visit(pBT->data);
		BTBianLiRecursion(pBT->lChild);
		BTBianLiRecursion(pBT->rChild);
	}
}



void BTBianLIZ(struct BTnode *pBT)//中序遍历非递归算法 
{
	struct sequenceStack *s;
	
	while(pBT != NULL || sequenceStackEmptyFull(pBT) == 0)
	if(pBT != NULL )
	{		
		sequenceStackPush(s,pBT);	
		pBT = pBT->lChild;
	}
	else
	{
		sequenceStackPop(s,&pBT);
		visit(pBT->data);
		pBT = pBT->rChild;
	}
	sequenceStackDestory(s);
}


void BTBianLiZRecursion(struct BTnode *pBT)//先序遍历递归算法 
{
	if(pBT != NULL)
	{
		BTBianLiZRecursion(pBT->lChild);
		visit(pBT->data);
		BTBianLiZRecursion(pBT->rChild);
	}
}

void BTBianLIC(struct BTnode *pBT)//层序遍历算法
{
	struct SeqQueue *Queue;
	
	Queue = SeqQueueCreat();
	
	SeqQueueIn(Queue,pBT);
	while(SeqQueueEmptyFull(Queue) != 0)
	{
		SeqQueueOut(Queue,&pBT);
		visit(pBT);
		if(pBT->lChild != NULL)
		{
			SeqQueueIn(Queue,pBT->lChild);
		}
		if(pBT->lChild != NULL)
		{
			SeqQueueIn(Queue,pBT->rChild);
		}
	}
	SeqQueueDestory(Queue);
} 



void visit(struct BTnode *pBT)
{
	printf("%c",pBT->data);
}


int main(int argc,char *argv[])
{
	return 0;
}

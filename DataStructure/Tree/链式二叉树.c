/*Ԥ���룺������������������������������������������������������������������������������������ */


/*�궨�壺����������������������������������������������������������������������������������*/
#define DT char 

/*ͷ�ļ�����������������������������������������������������������������������������������������*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"MyCode"
#include"SeqStack.c"

/*ȫ�ֱ�����������������������������������������������������������������������������������������*/  
struct BTnode
{
	struct BTnode *parent,*lChild,*rChild;//����˫�ס����ӡ��Һ���ָ��
	DT data;//�������
};

/*����������������������������������������������������������������������������������������������*/

struct BTnode *BTnodeCreat();
/*����˵��������һ���������ڵ� 
 *�������壺
 *����ֵ���壺���ظý���ָ�� 
 */ 
 
struct BTnode *BTCreat(DT array[]); 
 /*����˵����������(������)���������ַ����У�û�����Һ�����#��ʾ 
 *�������壺array��������ַ����У� 
 *����ֵ���壺 �������ĸ��ڵ�ָ�� 
 */ 
 
void BTBianLIX(struct BTnode *pBT);
 /*����˵�����������������  �ǵݹ��㷨 
 *�������壺
 *����ֵ���壺 
 */ 
 void BTBianLiXRecursion(struct BTnode *pBT)�� 
 /*����˵�����������������  �ݹ��㷨 
 *�������壺
 *����ֵ���壺 
 */ 

void BTBianLIZ(struct BTnode *pBT); 
/*����˵�����������������  �ǵݹ��㷨 
 *�������壺
 *����ֵ���壺 
 */ 
 void BTBianLiZRecursion(struct BTnode *pBT)
/*����˵�����������������  �ݹ��㷨 
 *�������壺
 *����ֵ���壺 
 */ 
 void visit(struct BTnode *pBT);
/*����˵�������ʸý������ 
 *�������壺
 *����ֵ���壺 
 */ 
 void BTBianLIC(struct BTnode *pBT);
/*����˵������������㷨
 *�������壺
 *����ֵ���壺 
 */ 
/*�������壺������������������������������������������������������������������������������������*/


/*���������ʣ� 
 *1������������������Ϊ0�Ľ��ĸ���Ϊn0����Ϊ2�Ľ��ĸ���Ϊn2����n0=n2+1; 
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
	
	s = sequenceStackCreat();//����һ��ջ	
		
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



void BTBianLIX(struct BTnode *pBT)//��������ǵݹ��㷨 
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

void BTBianLiXRecursion(struct BTnode *pBT)//��������ݹ��㷨 
{
	if(pBT != NULL)
	{
		visit(pBT->data);
		BTBianLiRecursion(pBT->lChild);
		BTBianLiRecursion(pBT->rChild);
	}
}



void BTBianLIZ(struct BTnode *pBT)//��������ǵݹ��㷨 
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


void BTBianLiZRecursion(struct BTnode *pBT)//��������ݹ��㷨 
{
	if(pBT != NULL)
	{
		BTBianLiZRecursion(pBT->lChild);
		visit(pBT->data);
		BTBianLiZRecursion(pBT->rChild);
	}
}

void BTBianLIC(struct BTnode *pBT)//��������㷨
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

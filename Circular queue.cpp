#include<iostream>
#define N 10
using namespace std;
int front=-1;
int rear=-1;
void display(int queue[])
{
        if(front==-1)
        {
                cout<<"Queue is empty"<<endl;
                return;
        }
        cout<<"Queue elements are:"<<endl;
        int i=front;
        while(true)
        {
                cout<<queue[i]<<" ";
                if(i==rear)
                        break;
                i=(i+1)%N;
        }
}
void enqueue(int queue[])
{
        int val;
        if((rear+1)%N ==front)
        {
                cout<<"Queue is already full";
                return;
        }
        cout<<"Enter a value for the Queue:";
        cin>>val;
        if(front==-1 && rear==-1)
        {
                front=0;rear=0;
        }
        else
        {
                rear=(rear+1)%N;
        }
        queue[rear]=val;
        display(queue);
}
void dequeue(int queue[])
{
        if(front==-1 && rear==-1)
        {
                cout<<"Queue is empty";
                return;
        }
        cout << "Dequeued element: " << queue[front] << endl;
        if(front ==rear)
        {
                front=-1;
                rear=-1;
        }
        else
        {
                front=(front+1)%N;
        }
        display(queue);
}
int main()
{
        int queue[N];int c;
        do
        {
                cout<<"Enter\n 1.For Enqueue\n 2.For dequeue\n 3.To End program:";
                cin>>c;
                switch(c)
                {
                        case 1:enqueue(queue);break;
                        case 2:dequeue(queue);break;
                        case 3:c=0;break;
                        default:cout<<"Enter a valid number:";break;
                }
        }while (c!=0);
        return 0;
}

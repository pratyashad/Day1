
import java.util.*;
public class Matrix
{
    int A[][],B[][],M,N;
    int arr[];
    Matrix(int mm,int nn)
    {
        M=mm;
        N=nn;
        A=new int[M][N];
        B=new int[M][N];
        arr=new int[(M*N)];
    }
    
    void input()
    {
       Scanner sc=new Scanner (System.in);
       System.out.println("Enter elemnts");
       for(int i=0;i<M;i++)
       {
           for(int j=0;j<N;j++)
           {
               A[i][j]=sc.nextInt();
            }
        }
    }
    
    void fill()
    {
        int x=0;
        for(int i=0;i<M;i++)
       {
           for(int j=0;j<N;j++)
           {
               arr[x++]=A[i][j];
            }
        }
        
        
    }
    
    void sort()
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n-i-1;j++)
          {
              if(arr[j+1]>arr[j])
              {
                  int temp=arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                }
            }
        }
        
    }
    
    void transfer()
    {
        int x=0;
        for(int i=0;i<M;i++)
       {
           for(int j=0;j<N;j++)
           {
               B[i][j]=arr[x++];
            }
        }
        
    }
    
    void displayoriginal()
    {
        System.out.println("Oriinal matrix");
        for(int i=0;i<M;i++)
       {
           for(int j=0;j<N;j++)
           {
               System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }   
        int sum=add(A);
        System.out.println("sum of boundary elements(unsorted)= "+sum);
    }
    
    void displaysort()
    {
        System.out.println("Sorted matrix");
        for(int i=0;i<M;i++)
       {
           for(int j=0;j<N;j++)
           {
               System.out.print(B[i][j]+"\t");
            }
            System.out.println();
        }   
        int sum=add(B);
        System.out.println("sum of boundary elements(sorted)= "+sum);
    }
    
    int add(int aa[][])
    {
        int s=0;
        for(int i=0;i<M;i++)
        {
          s+=aa[i][0]+aa[i][N-1];
        }
        
        for(int j=0;j<N;j++)
        {
          s+=aa[0][j]+aa[M-1][j];
        }
        s=s-(aa[0][0]+aa[0][N-1]+aa[M-1][0]+aa[M-1][N-1]);
        
        return s;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter row column");
        int m1=sc.nextInt();
        int n1=sc.nextInt();
        
        if((m1<=2 || m1>=8) || (n1<=2 || n1>=8))
        System.out.println("out of range");
        
        else
        {
            Matrix obj=new Matrix(m1,n1);
            obj.input();
            obj.fill();
            obj.sort();
            obj.transfer();
            obj.displayoriginal();
            obj.displaysort();
        }
    }
}
    
        
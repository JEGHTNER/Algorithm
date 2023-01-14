#include <string>
#include <vector>
#include <stack>
#include "printDictionary.cpp"
using namespace std;

int check_stack(vector<int> *stack)
{
    int i = 0;
    int count = 0;
    for(int i = 0; i < (*stack).size() - 1; i++)
    {
        if ((*stack)[i] == (*stack)[i + 1])
       {
        cout<<"i="<<i<<endl;
        count +=2;
        (*stack).erase((*stack).begin() + (i + 1));
        (*stack).erase((*stack).begin() + i);
       }
    }
    return count;
}

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int>  stac;
    vector<int> test = {4,2, 3, 1, 1, 3, 2, 4};
    for (int i = 0 ; i < moves.size(); i++)
    {
        for (int col = 0 ; col<board.size(); col++)
        {
            if (board[col][moves[i] - 1] != 0)
            {
                stack.push_back(board[col][moves[i] - 1]);
                if (!stack.empty() && stack.top)
                answer += check_stack(&stack);
                check_stack(&test);
                printDictionary(test);
                board[col][moves[i] - 1] = 0;
                break ;
            }
        }
    }
    //printDictionary(stack);
    return answer;
}

#include<iostream>

int main()
{
    vector<vector<int>> board = {
        {0,0,0,0,0},
        {0,0,1,0,3},
        {0,2,5,0,1},
        {4,2,4,4,2},
        {3,5,1,3,1}
        };
    vector<int> moves = {1,5,3,5,1,2,1,4};
    cout << solution(board, moves);
}
#include <iostream>
#include <vector>

void printDictionary(std::vector <int> v)
{
    for (int i = 0; i < v.size(); i ++)
        std::cout<<v[i] <<" ";
    std::cout<<std::endl;
}
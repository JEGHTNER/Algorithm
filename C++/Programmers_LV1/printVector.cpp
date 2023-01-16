#include <iostream>
#include <string>
#include <vector>

void printVector(std::vector <int> v)
{
    for (int i = 0; i < v.size(); i ++)
        std::cout<<v[i] <<" ";
    std::cout<<std::endl;
}

void printVector(std::vector <std::string> v)
{
    for (int i = 0; i < v.size(); i ++)
        std::cout<<v[i] <<" ";
    std::cout<<std::endl;
}

void printVector(std::vector <char> v)
{
    for (int i = 0; i < v.size(); i ++)
        std::cout<<v[i] <<" ";
    std::cout<<std::endl;
}
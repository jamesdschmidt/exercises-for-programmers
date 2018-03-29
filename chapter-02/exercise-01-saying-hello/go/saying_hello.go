/*
A program that prompts for your name and prints a greeting using your name.
Exercise 1 Saying Hello, Exercises for Programmers by Brian Hogan

By James Schmidt
*/
package main

import (
  "bufio"
  "fmt"
  "os"
  "strings"
)

func main() {
  reader := bufio.NewReader(os.Stdin)
  fmt.Printf("What is your name? ")
  name, _ := reader.ReadString('\n')
  name = strings.TrimSuffix(name, "\n")

  greeting := "Hello, " + name + ", nice to meet you!"
  fmt.Println(greeting)
}

const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('What is the first number? ', (firstAnswer) => {
  const firstNumber = parseInt(firstAnswer);
  rl.question('What is the second number? ', (secondAnswer) => {
    const secondNumber = parseInt(secondAnswer);

    const sum = firstNumber + secondNumber;
    const difference = firstNumber - secondNumber;
    const product = firstNumber * secondNumber;
    const quotient = Math.trunc(firstNumber / secondNumber);
    console.log(`${firstNumber} + ${secondNumber} = ${sum}\n${firstNumber} - ${secondNumber} = ${difference}\n${firstNumber} * ${secondNumber} = ${product}\n${firstNumber} / ${secondNumber} = ${quotient}`);

    rl.close();
  });
});

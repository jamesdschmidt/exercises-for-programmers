const readline = require('readline');
const rl = readline.createInterface(process.stdin, process.stdout);

rl.question('What is the first number? ', (answer) => {
  const firstNumber = parseInt(answer);
  rl.question('What is the second number? ', (answer) => {
    const secondNumber = parseInt(answer);

    const sum = firstNumber + secondNumber;
    const difference = firstNumber - secondNumber;
    const product = firstNumber * secondNumber;
    const quotient = Math.trunc(firstNumber / secondNumber);
    console.log(`${firstNumber} + ${secondNumber} = ${sum}\n${firstNumber} - ${secondNumber} = ${difference}\n${firstNumber} * ${secondNumber} = ${product}\n${firstNumber} / ${secondNumber} = ${quotient}`);

    rl.close();
  });
});

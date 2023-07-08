import fs from "fs";

function initBoard(initialBoard) {
  let board = []
  initialBoard.forEach((l) => {
    for (let i = 1, j = 0; i <= l.length; i += 4, j++) {
      let line = l.split("")
      if (board[j] === undefined) board[j] = []
      if (line[i] != " ") board[j].unshift(line[i]);
    }
  });
  return board
}

function solve1(board, operation) {
  for (let i = 0; i < operation[0]; i++) {
    let crate = board[operation[1] - 1].pop();
    board[operation[2] - 1].push(crate);
  }
}

function solve2(board, operation) {
  let buffer = []
  for (let i = 0; i < operation[0]; i++) {
    buffer.unshift(board[operation[1] - 1].pop())
  }
  console.log(buffer)
  board[operation[2] - 1] = board[operation[2] - 1].concat(buffer);
}

fs.readFile("input.txt", "utf8", (err, data) => {
  let board = initBoard(data.split("\n").slice(0, 8));
  let operations = data.split("\n").slice(10, -1).map(operation => operation.match(/\d+/g))
  // operations.forEach(operation => { solve1(board, operation) });
  operations.forEach(operation => { solve2(board, operation) });
  console.log(board.map(stack => stack.at(-1)))
});

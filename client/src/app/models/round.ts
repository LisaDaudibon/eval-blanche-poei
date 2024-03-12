export class Round {
  constructor(public id: string, public attempt: number, public lettersSearched: string[], public state: string, public roundWord: string) {}
}

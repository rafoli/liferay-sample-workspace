export class Sample {
  constructor(
    public id: string,
    public name: string
  ) {
  }
}

export class SamplePaginated {
  constructor(
    public items: Sample[],
    public pageSize: number,
    public lastPage: number,
    public totalCount: number,
    public page: number
  ) {
  }
}

export interface ISample {
  id: number;
  name: string;
}

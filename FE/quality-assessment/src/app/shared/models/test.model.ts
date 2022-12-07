export interface CreateTestModel {
  name: string,
  documents: TestItem[],
  verifications: TestItem[]
}

export interface TestItem {
  id: string | null,
  count: number | null
}

export interface Test {
  name: string,
  createAt: Date,
  documents: TestItem[],
  verifications: TestItem[]
}

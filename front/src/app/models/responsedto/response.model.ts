export interface Response<T> {
    result: boolean;
    data: T;
    errorMessage: string;
}
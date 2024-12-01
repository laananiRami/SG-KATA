import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TransformResult } from '../models/transform-result';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransformService {

  private readonly apiUrl = 'http://localhost:8080/api/v1/transform';

  constructor(private http: HttpClient) {}

  transform(number: number): Observable<TransformResult> {
    return this.http.get<TransformResult>(`${this.apiUrl}/${number}`);
  }
}

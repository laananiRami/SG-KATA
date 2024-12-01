import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { ReactiveFormsModule } from "@angular/forms";
import { AppRoutModule } from "./app.routes";
import { TransformService } from "./services/transform.service";

@NgModule({
    imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutModule
  ],
  providers: [TransformService]
})
  export class AppModule { }



import {
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
} from "@angular/common/http";

export class Intercept implements HttpInterceptor {
  constructor() {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (
      sessionStorage.getItem("token") != undefined ||
      sessionStorage.getItem("token") != null
    ) {
      req = req.clone({
        setHeaders: {
          Authorization: "Bearer " + sessionStorage.getItem("token"),
        },
      });
    }

    return next.handle(req);
  }
}

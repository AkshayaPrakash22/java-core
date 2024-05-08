import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appPagination]'
})
export class PaginationDirective {
  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) {}

  @Input() set appPagination(currentPage: number) {
    this.viewContainer.clear();
    this.viewContainer.createEmbeddedView(this.templateRef, {
      $implicit: currentPage
    });
  }

  @Input() set firstIndex(firstIndex: number) {
    // You can use this input to handle the pagination UI if needed
  }

  @Input() set lastIndex(lastIndex: number) {
    // You can use this input to handle the pagination UI if needed
  }
}

import { Directive, ElementRef, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  @HostBinding('style.backgroundColor')
  private bgColor:string = 'lightyellow'


  @HostListener('mouseover')
  public handleMouseOver(){
    this.bgColor = 'lightblue';
  }

  @HostListener('mouseout')
  public handleMouseOut(){
    this.bgColor = 'lightyellow';
  }
  

  constructor(private eleRef: ElementRef) { 

    // console.log('object of hightlight directive is created')
    // console.log(this.eleRef.nativeElement)
    // this.eleRef.nativeElement.style.backgroundColor = 'yellow'
  }

}

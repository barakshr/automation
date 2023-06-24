package com.team.framwork.selenium.controls.elements;

import com.team.framwork.selenium.controls.api.ImplementedBy;

import java.util.List;

@ImplementedBy(DropdownImp.class)
public interface Dropdown extends Control {
    void selectFormDropdown(String selectionText);

    List<String> getDropdownOptions();

}

package com.team.selenium.controls.elements;

import com.team.selenium.controls.api.ImplementedBy;

import java.util.List;

@ImplementedBy(DropdownImp.class)
public interface Dropdown extends Control {
    public void selectFormDropdown(String selectionText);

    List<String> getDropdownOptions();

}

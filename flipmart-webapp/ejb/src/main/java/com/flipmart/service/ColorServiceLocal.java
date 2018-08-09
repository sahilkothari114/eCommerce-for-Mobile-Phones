package com.flipmart.service;

import com.flipmart.persistence.Color;

public interface ColorServiceLocal {
 public Color findById(Long colorId);
 public void addColor(Color color);
}

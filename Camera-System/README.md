# Camera System Design Documentation

## Overview

The Camera System is designed to handle image capture requests from multiple clients with varying urgency levels. It prioritizes requests, processes them asynchronously, and provides appropriate callbacks based on the capture result. This document includes both High-Level Design (HLD) and Low-Level Design (LLD) details.

## High-Level Design (HLD)

### 1. System Overview

The camera system manages image capture requests, prioritizing them based on urgency and processing them asynchronously. It ensures that requests are handled efficiently and clients receive appropriate callbacks.

### 2. Components and Responsibilities

#### 2.1. Client

- **Responsibility**:
    - Submit capture requests with urgency levels.
    - Register callbacks for success or failure.
    - Receive the result of the capture request.

#### 2.2. Priority Queue

- **Responsibility**:
    - Store requests with urgency levels.
    - Sort and prioritize requests based on urgency.

#### 2.3. Scheduler

- **Responsibility**:
    - Retrieve requests from the Priority Queue.
    - Dispatch requests to the Camera System based on priority.
    - Ensure requests are processed in the correct order.

#### 2.4. Camera System

- **Responsibility**:
    - Process capture requests.
    - Interface with the Camera Interface to capture images.
    - Handle success and failure callbacks for clients.

#### 2.5. Camera Interface

- **Responsibility**:
    - Provide the actual interface to the camera hardware.
    - Capture images as requested by the Camera System.

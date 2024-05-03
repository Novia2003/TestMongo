package org.example.service;

import org.bson.types.ObjectId;
import org.example.model.entity.mongo.Group;
import org.example.repository.mongo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(ObjectId id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        return groupOptional.orElse(null);
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(ObjectId id, Group group) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (groupOptional.isPresent()) {
            group.setId(id);
            return groupRepository.save(group);
        } else {
            return null;
        }
    }

    public void deleteGroup(ObjectId id) {
        groupRepository.deleteById(id);
    }
}
